package com.bmf.api.impl.business;

import com.bmf.api.Result;
import com.bmf.api.business.BusinessCmdService;
import com.bmf.api.business.BusinessReqDTO;
import com.bmf.base.BusinessDomain;
import com.bmf.common.enums.BizCodeEnum;
import com.bmf.common.exception.BizException;
import com.bmf.base.Business;
import com.bmf.common.utils.ResultUtil;
import com.bmf.core.business.BusinessService;
import com.bmf.core.design.BusinessDomainDesign4Strategy;
import com.bmf.core.domain.DomainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class BusinessCmdServiceImpl implements BusinessCmdService {

    @Autowired
    private BusinessService businessService;
    @Autowired
    private DomainService domainService;
    @Autowired
    private BusinessDomainDesign4Strategy businessDomainDesign4Strategy;

    @Override
    public Result<Boolean> create(BusinessReqDTO req) {
        return ResultUtil.success(businessService.createBusiness(req.getBusiness()));
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
        BusinessDomain domain = domainService.queryDomain(businessReqDTO.getDomain());
        if (Objects.isNull(domain)) {
            throw new BizException(BizCodeEnum.DOMAIN_NOT_EXIST);
        }
        return ResultUtil.success(businessService.addDomain(businessReqDTO.getBusiness(), businessReqDTO.getDomain()));
    }

    @Override
    public Result<Boolean> delDomain(BusinessReqDTO businessReqDTO) {
        return ResultUtil.success(businessService.delDomain(businessReqDTO.getBusiness(), businessReqDTO.getDomain()));
    }

    @Override
    public Result<Boolean> buildDomainRelation(BusinessReqDTO businessReqDTO) {
        return ResultUtil.success(businessDomainDesign4Strategy.buildBusinessDomainRelationship(businessReqDTO.getRelationship()));
    }

    @Override
    public Result<Boolean> removeDomainRelation(BusinessReqDTO businessReqDTO) {
        return ResultUtil.success(businessDomainDesign4Strategy.removeBusinessDomainRelationship(businessReqDTO.getRelationship()));
    }
}
