package com.bmf.api.impl.business;

import com.bmf.api.Result;
import com.bmf.api.business.BusinessCmdService;
import com.bmf.api.business.BusinessReqDTO;
import com.bmf.core.business.BusinessService;
import com.bmf.core.design.BusinessDomainDesign4Strategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public Result<Boolean> addDomainRelation(BusinessReqDTO businessReqDTO) {
        return Result.success(businessDomainDesign4Strategy.buildBusinessDomainRelationship(businessReqDTO.getRelationship()));
    }

    @Override
    public Result<Boolean> delDomainRelation(BusinessReqDTO businessReqDTO) {
        return Result.success(businessDomainDesign4Strategy.removeBusinessDomainRelationship(businessReqDTO.getRelationship()));
    }
}
