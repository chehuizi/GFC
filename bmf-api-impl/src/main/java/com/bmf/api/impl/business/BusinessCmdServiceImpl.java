package com.bmf.api.impl.business;

import com.bmf.api.Result;
import com.bmf.api.business.BusinessCmdService;
import com.bmf.api.business.BusinessReqDTO;
import com.bmf.base.BusinessDomain;
import com.bmf.common.enums.BizCodeEnum;
import com.bmf.base.Business;
import com.bmf.common.utils.BusinessCheckUtil;
import com.bmf.common.utils.ResultUtil;
import com.bmf.common.validator.Validator;
import com.bmf.core.business.BusinessService;
import com.bmf.core.design.BusinessDomainDesign4Strategy;
import com.bmf.core.domain.DomainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BusinessCmdServiceImpl implements BusinessCmdService {

    @Autowired
    private BusinessService businessService;
    @Autowired
    private DomainService domainService;
    @Autowired
    private BusinessDomainDesign4Strategy businessDomainDesign4Strategy;

    @Override
    @Validator(beanName = "businessReqDTOValidator", method = "v4Create")
    public Result<Boolean> create(BusinessReqDTO req) {
        Business business = businessService.queryBusiness(req.getBusiness());
        BusinessCheckUtil.checkNonNull(business, BizCodeEnum.BUSINESS_IS_EXISTED);
        return ResultUtil.success(businessService.createBusiness(req.getBusiness()));
    }

    @Override
    public Result<Boolean> update(BusinessReqDTO req) {
        return ResultUtil.fail(BizCodeEnum.FUNCTION_NOT_SUPPORT);
    }

    @Override
    public Result<Boolean> delete(BusinessReqDTO req) {
        return ResultUtil.fail(BizCodeEnum.FUNCTION_NOT_SUPPORT);
    }

    @Override
    @Validator(beanName = "businessReqDTOValidator", method = "v4AddDomain")
    public Result<Boolean> addDomain(BusinessReqDTO businessReqDTO) {
        Business business = businessService.queryBusiness(businessReqDTO.getBusiness());
        BusinessCheckUtil.checkNull(business, BizCodeEnum.BUSINESS_NOT_EXIST);
        BusinessDomain domain = domainService.queryDomain(businessReqDTO.getDomain());
        BusinessCheckUtil.checkNull(domain, BizCodeEnum.DOMAIN_NOT_EXIST);
        return ResultUtil.success(businessService.addDomain(businessReqDTO.getBusiness(), businessReqDTO.getDomain()));
    }

    @Override
    @Validator(beanName = "businessReqDTOValidator", method = "v4DelDomain")
    public Result<Boolean> delDomain(BusinessReqDTO businessReqDTO) {
        Business business = businessService.queryBusiness(businessReqDTO.getBusiness());
        BusinessCheckUtil.checkNull(business, BizCodeEnum.BUSINESS_NOT_EXIST);
        BusinessDomain domain = domainService.queryDomain(businessReqDTO.getDomain());
        BusinessCheckUtil.checkNull(domain, BizCodeEnum.DOMAIN_NOT_EXIST);
        return ResultUtil.success(businessService.delDomain(businessReqDTO.getBusiness(), businessReqDTO.getDomain()));
    }

    @Override
    public Result<Boolean> buildDomainRelation(BusinessReqDTO businessReqDTO) {
        Business business = businessService.queryBusiness(businessReqDTO.getBusiness());
        BusinessCheckUtil.checkNull(business, BizCodeEnum.BUSINESS_NOT_EXIST);
        BusinessDomain domainA = domainService.queryDomain(businessReqDTO.getRelationship().getRoleA().getDomain());
        BusinessCheckUtil.checkNull(domainA, BizCodeEnum.DOMAIN_NOT_EXIST);
        BusinessDomain domainB = domainService.queryDomain(businessReqDTO.getRelationship().getRoleB().getDomain());
        BusinessCheckUtil.checkNull(domainB, BizCodeEnum.DOMAIN_NOT_EXIST);
        return ResultUtil.success(businessDomainDesign4Strategy.buildBusinessDomainRelationship(businessReqDTO.getRelationship()));
    }

    @Override
    public Result<Boolean> removeDomainRelation(BusinessReqDTO businessReqDTO) {
        Business business = businessService.queryBusiness(businessReqDTO.getBusiness());
        BusinessCheckUtil.checkNull(business, BizCodeEnum.BUSINESS_NOT_EXIST);
        BusinessDomain domainA = domainService.queryDomain(businessReqDTO.getRelationship().getRoleA().getDomain());
        BusinessCheckUtil.checkNull(domainA, BizCodeEnum.DOMAIN_NOT_EXIST);
        BusinessDomain domainB = domainService.queryDomain(businessReqDTO.getRelationship().getRoleB().getDomain());
        BusinessCheckUtil.checkNull(domainB, BizCodeEnum.DOMAIN_NOT_EXIST);
        return ResultUtil.success(businessDomainDesign4Strategy.removeBusinessDomainRelationship(businessReqDTO.getRelationship()));
    }
}
