package com.bmf.api.impl.business;

import com.bmf.api.Result;
import com.bmf.api.business.BusinessCmdService;
import com.bmf.api.business.BusinessReqDTO;
import com.bmf.api.business.BusinessRespDTO;
import com.bmf.base.Business;
import com.bmf.base.DO.BusinessRelDomainDO;
import com.bmf.common.utils.BusinessUtil;
import com.bmf.common.validator.ParamValidator;
import com.bmf.core.business.BusinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BusinessCmdServiceImpl implements BusinessCmdService {

    @Autowired
    private BusinessService businessService;

    @Override
    public Result<Boolean> create(BusinessReqDTO req) {
        Business business = BusinessUtil.convert(req);
        boolean ret = businessService.addBusiness(business);
        return Result.success(ret);
    }

    @Override
    public Result<Boolean> update(BusinessReqDTO req) {
        return null;
    }

    @Override
    public Result<Boolean> delete(BusinessReqDTO req) {
        return null;
    }

    @Override
    public Result<BusinessRespDTO> queryOne(BusinessReqDTO req) {
        return null;
    }

    @Override
    @ParamValidator
    public Result<Boolean> addDomain(BusinessReqDTO businessReqDTO) {
        BusinessRelDomainDO businessRelDomainDO = BusinessUtil.convertBusinessRelDomainDO(businessReqDTO);
        boolean result = businessService.addDomain(businessRelDomainDO);
        return Result.success(result);
    }

    @Override
    public Result<Boolean> addDomainRelation(BusinessReqDTO businessReqDTO) {
        boolean result = businessService.addDomainRelation(null);
        return Result.success(result);
    }
}
