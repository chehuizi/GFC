package com.bmf.api.impl.business;

import com.bmf.api.Result;
import com.bmf.api.business.BusinessQryService;
import com.bmf.api.business.BusinessReqDTO;
import com.bmf.api.business.BusinessRespDTO;
import com.bmf.base.Business;
import com.bmf.base.BusinessDomain;
import com.bmf.base.DO.BusinessRelDomainDO;
import com.bmf.common.utils.ResultUtil;
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
    public Result<BusinessRespDTO> queryOne(BusinessReqDTO req) {
        Business business = businessService.queryBusiness(req.getBusiness());
        if (req.isIncludeDomain() && Objects.nonNull(business)) {
            List<BusinessRelDomainDO> businessRelDomainDOList =  businessService.queryBusinessRelDomain(business);
            if (Objects.nonNull(businessRelDomainDOList) && businessRelDomainDOList.size() > 0) {
                List<BusinessDomain> businessDomainList = domainService.queryDomainList(fetchDomainCode(businessRelDomainDOList));
                business.setBusinessDomainList(businessDomainList);
            }
        }
        BusinessRespDTO respDTO = new BusinessRespDTO(business);
        return ResultUtil.success(respDTO);
    }

    /**
     * 提取domainCode
     * @param businessRelDomainDOList
     * @return
     */
    private List<Integer> fetchDomainCode(List<BusinessRelDomainDO> businessRelDomainDOList) {
        List<Integer> domainCodeList = new ArrayList<>();
        for (BusinessRelDomainDO item : businessRelDomainDOList) {
            domainCodeList.add(item.getDomainCode());
        }
        return domainCodeList;
    }
}
