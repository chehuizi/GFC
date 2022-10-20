package com.bmf.api.impl.business;

import com.bmf.api.Result;
import com.bmf.api.business.BusinessCmdService;
import com.bmf.api.business.BusinessReqDTO;
import com.bmf.api.enums.BizCodeEnum;
import com.bmf.api.exception.BizException;
import com.bmf.base.Business;
import com.bmf.core.business.BusinessService;
import com.bmf.core.design.BusinessDomainDesign4Strategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class BusinessCmdServiceImpl implements BusinessCmdService {

    @Autowired
    private BusinessService businessService;
    @Autowired
    private BusinessDomainDesign4Strategy businessDomainDesign4Strategy;

    @Override
    public Result<Boolean> create(BusinessReqDTO req) {
        return Result.success(businessService.createBusiness(req.getBusiness()));
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
    public Result<Boolean> addDomain(BusinessReqDTO businessReqDTO) {
        Business business = businessService.queryBusiness(businessReqDTO.getBusiness());
        if (Objects.isNull(business)) {
            throw new BizException(BizCodeEnum.BUSINESS_NOT_EXIST);
        }
        return Result.success(businessService.addDomain(businessReqDTO.getBusiness(), businessReqDTO.getDomain()));
    }

    @Override
    public Result<Boolean> delDomain(BusinessReqDTO businessReqDTO) {
        return Result.success(businessService.delDomain(businessReqDTO.getBusiness(), businessReqDTO.getDomain()));
    }

    @Override
    public Result<Boolean> buildDomainRelation(BusinessReqDTO businessReqDTO) {
        return Result.success(businessDomainDesign4Strategy.buildBusinessDomainRelationship(businessReqDTO.getRelationship()));
    }

    @Override
    public Result<Boolean> removeDomainRelation(BusinessReqDTO businessReqDTO) {
        return Result.success(businessDomainDesign4Strategy.removeBusinessDomainRelationship(businessReqDTO.getRelationship()));
    }
}
