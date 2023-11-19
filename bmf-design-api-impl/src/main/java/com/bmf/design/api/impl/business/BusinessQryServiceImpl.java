package com.bmf.design.api.impl.business;

import com.bmf.common.api.Result;
import com.bmf.design.api.business.BusinessQryService;
import com.bmf.design.api.business.dto.BusinessQryReqDTO;
import com.bmf.design.api.business.dto.BusinessRespDTO;
import com.bmf.design.model.Business;
import com.bmf.design.model.Domain;
import com.bmf.design.model.DomainRelation;
import com.bmf.design.model.BusinessRelDomain;
import com.bmf.common.api.utils.ResultUtil;
import com.bmf.common.api.validator.Validator;
import com.bmf.design.core.business.BusinessService;
import com.bmf.design.core.domain.DomainService;
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
                List<Domain> domainList = domainService.queryDomainByCode(
                        businessRelDomainList.stream().map(BusinessRelDomain::getDomainCode).
                                collect(Collectors.toList()));
                domainList.forEach(item ->
                        item.setDomainPosition(businessRelDomainMap.get(item.getDomainCode()).getDomainPosition()));
                business.setDomainList(domainList);
            }
        }
        if (req.isIncludeDomainRelation()) {
            List<DomainRelation> domainRelationList = businessService.queryBusinessDomainRelation(business);
            business.setDomainRelationList(domainRelationList);
        }

        return ResultUtil.success(new BusinessRespDTO(business));
    }

}
