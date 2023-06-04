package com.bmf.api.impl.business;

import com.bmf.api.Result;
import com.bmf.api.business.BusinessQryService;
import com.bmf.api.business.dto.BusinessQryReqDTO;
import com.bmf.api.business.dto.BusinessRespDTO;
import com.bmf.base.Business;
import com.bmf.base.BusinessDomain;
import com.bmf.base.BusinessDomainRelation;
import com.bmf.base.BusinessRelDomain;
import com.bmf.common.utils.ResultUtil;
import com.bmf.common.validator.Validator;
import com.bmf.core.business.BusinessService;
import com.bmf.core.domain.DomainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class BusinessQryServiceImpl implements BusinessQryService {

    @Autowired
    private BusinessService businessService;
    @Autowired
    private DomainService domainService;

    @Override
    @Validator(beanName = "businessQryReqDTOValidator", method = "v4QueryOne")
    public Result<BusinessRespDTO> queryOne(BusinessQryReqDTO req) {
        Business business = businessService.queryBusiness(req.getBusiness());
        if (Objects.isNull(business)) {
            return ResultUtil.success(new BusinessRespDTO(null));
        }

        if (req.isIncludeDomain()) {
            List<BusinessRelDomain> businessRelDomainList =  businessService.queryBusinessRelDomain(business);
            Map<Integer, BusinessRelDomain> businessRelDomainMap = businessRelDomainList.stream().
                    collect(Collectors.toMap(e -> e.getDomainCode(), e -> e));
            if (Objects.nonNull(businessRelDomainList) && businessRelDomainList.size() > 0) {
                List<BusinessDomain> businessDomainList = domainService.queryDomainList(
                        businessRelDomainList.stream().map(BusinessRelDomain::getDomainCode).
                                collect(Collectors.toList()));
                businessDomainList.forEach(item ->
                        item.setDomainPosition(businessRelDomainMap.get(item.getDomainCode()).getDomainPosition()));
                business.setBusinessDomainList(businessDomainList);
            }
        }
        if (req.isIncludeDomainRelation()) {
            List<BusinessDomainRelation> businessDomainRelationList = businessService.queryBusinessDomainRelation(business);
            business.setBusinessDomainRelationList(businessDomainRelationList);
        }

        return ResultUtil.success(new BusinessRespDTO(business));
    }

}
