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

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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
            if (Objects.nonNull(businessRelDomainList) && businessRelDomainList.size() > 0) {
                List<BusinessDomain> businessDomainList = domainService.queryDomainList(fetchDomainCode(businessRelDomainList));
                business.setBusinessDomainList(businessDomainList);
            }
        }
        if (req.isIncludeDomainRelation()) {
            List<BusinessDomainRelation> businessDomainRelationList = businessService.queryBusinessDomainRelation(business);
            business.setBusinessDomainRelationList(businessDomainRelationList);
        }

        return ResultUtil.success(new BusinessRespDTO(business));
    }

    /**
     * 提取domainCode
     * @param businessRelDomainList
     * @return
     */
    private List<Integer> fetchDomainCode(List<BusinessRelDomain> businessRelDomainList) {
        List<Integer> domainCodeList = new ArrayList<>();
        for (BusinessRelDomain item : businessRelDomainList) {
            domainCodeList.add(item.getDomainCode());
        }
        return domainCodeList;
    }
}
