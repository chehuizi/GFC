package com.bmf.api.impl.business;

import com.bmf.api.Result;
import com.bmf.api.business.BusinessCmdService;
import com.bmf.api.business.dto.BusinessCmdReqDTO;
import com.bmf.base.BusinessDomain;
import com.bmf.base.BusinessDomainRelation;
import com.bmf.base.BusinessRelDomain;
import com.bmf.base.enums.CodeKeyEnum;
import com.bmf.base.snapshot.DomainStrategyDesignSnapshot;
import com.bmf.base.strategy.BusinessDomainRelationship;
import com.bmf.common.enums.BizCodeEnum;
import com.bmf.base.Business;
import com.bmf.common.utils.BusinessCheckUtil;
import com.bmf.common.utils.ResultUtil;
import com.bmf.common.validator.Validator;
import com.bmf.core.business.BusinessService;
import com.bmf.core.design.BusinessDomainDesign4Strategy;
import com.bmf.core.domain.DomainService;
import com.bmf.infrastructure.generator.CodeSeqGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class BusinessCmdServiceImpl implements BusinessCmdService {

    private static final Logger logger = LoggerFactory.getLogger(BusinessCmdServiceImpl.class);

    @Autowired
    private BusinessService businessService;
    @Autowired
    private DomainService domainService;
    @Autowired
    private BusinessDomainDesign4Strategy businessDomainDesign4Strategy;
    @Autowired
    private CodeSeqGenerator codeSeqGenerator;

    @Override
    @Validator(beanName = "businessCmdReqDTOValidator", method = "v4Create")
    public Result<Boolean> create(BusinessCmdReqDTO req) {
        Business business = businessService.queryBusiness(req.getBusiness());
        BusinessCheckUtil.checkNonNull(business, BizCodeEnum.BUSINESS_IS_EXISTED);
        req.getBusiness().setBusinessCode(codeSeqGenerator.genSeqByCodeKey(CodeKeyEnum.CODE_KEY_BUSINESS.getKey()));
        return ResultUtil.success(businessService.createBusiness(req.getBusiness()));
    }

    @Override
    @Validator(beanName = "businessCmdReqDTOValidator", method = "v4Update")
    public Result<Boolean> update(BusinessCmdReqDTO req) {
        return ResultUtil.success(businessService.updateBusiness(req.getBusiness()));
    }

    @Override
    public Result<Boolean> delete(BusinessCmdReqDTO req) {
        return ResultUtil.fail(BizCodeEnum.FUNCTION_NOT_SUPPORT);
    }

    @Override
    @Validator(beanName = "businessCmdReqDTOValidator", method = "v4SaveStrategyDesign")
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED)
    public Result<Boolean> saveStrategyDesignV2(BusinessCmdReqDTO businessCmdReqDTO) {
        // 查询
        List<BusinessDomain> domainList = domainService.queryDomainByBusinessCode(
                businessCmdReqDTO.getBusiness().getBusinessCode());
        List<BusinessRelDomain> businessRelDomainList = businessService.queryBusinessRelDomain(
                businessCmdReqDTO.getBusiness());
        List<BusinessDomainRelation> domainRelationList = businessService.queryBusinessDomainRelation(
                businessCmdReqDTO.getBusiness());
        DomainStrategyDesignSnapshot snapshot = DomainStrategyDesignSnapshot.builder()
                .domainList(domainList)
                .businessRelDomainList(businessRelDomainList)
                .domainRelationList(domainRelationList)
                .build();
        // 备份

        // 删除
        return null;
    }

    @Override
    @Validator(beanName = "businessCmdReqDTOValidator", method = "v4SaveStrategyDesign")
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED)
    public Result<Boolean> saveStrategyDesign(BusinessCmdReqDTO businessCmdReqDTO) {
        Business business = businessService.queryBusiness(businessCmdReqDTO.getBusiness());
        BusinessCheckUtil.checkNull(business, BizCodeEnum.BUSINESS_NOT_EXIST);
        // step1：处理领域
        boolean result = true;
        List<BusinessDomain> existedDomains = domainService.queryDomainByAlias(business.getBusinessCode(),
                businessCmdReqDTO.getDomainList().stream().map(BusinessDomain::getDomainAlias)
                        .collect(Collectors.toList()));
        Map<String, BusinessDomain> existedDomainMap = existedDomains.stream().collect(
                Collectors.toMap(e -> e.getDomainAlias(), e -> e));

        List<BusinessDomain> insertedDomains = new ArrayList<>();
        List<BusinessDomain> updatedDomains = new ArrayList<>();
        for (BusinessDomain domain : businessCmdReqDTO.getDomainList()) {
            if (Objects.isNull(existedDomainMap.get(domain.getDomainAlias()))) {
                domain.setDomainCode(codeSeqGenerator.genSeqByCodeKey(CodeKeyEnum.CODE_KEY_DOMAIN.getKey()));
                insertedDomains.add(domain);
            } else {
                BusinessCheckUtil.checkNull(domain.getDomainCode(), BizCodeEnum.STRATEGY_DESIGN_DOMAIN_CODE_IS_NULL);
                updatedDomains.add(domain);
            }
        }

        if (!insertedDomains.isEmpty()) {
            result = domainService.batchCreateDomain(insertedDomains);
        }
        BusinessCheckUtil.checkTrue(result, BizCodeEnum.STRATEGY_DESIGN_DOMAIN_INSERTED_FAILED);

        if (!updatedDomains.isEmpty()) {
            result = domainService.batchCreateDomain(updatedDomains);
        }
        BusinessCheckUtil.checkTrue(result, BizCodeEnum.STRATEGY_DESIGN_DOMAIN_UPDATED_FAILED);

        // step2：处理业务和领域关系
        if (!insertedDomains.isEmpty()) {
            result = businessService.addDomainList(business, businessCmdReqDTO.getDomainList());
        }
        BusinessCheckUtil.checkTrue(result, BizCodeEnum.STRATEGY_DESIGN_BUSINESS_REL_DOMAIN_HANDLE_FAILED);

        // step3：处理领域关系
        if (businessCmdReqDTO.getRelationshipList().size() > 0) {
            fillRelationship(businessCmdReqDTO.getDomainList(), businessCmdReqDTO.getRelationshipList());
            result = businessDomainDesign4Strategy.batchBuildBusinessDomainRelationship(business, businessCmdReqDTO.getRelationshipList());
            BusinessCheckUtil.checkTrue(result, BizCodeEnum.STRATEGY_DESIGN_DOMAIN_RELATION_HANDLE_FAILED);
        }
        return ResultUtil.success(Boolean.TRUE);
    }

    /**
     * 处理领域
     * @param businessDomainList
     */

    /**
     * 填充领域关系
     * @param domainList
     * @param relationshipList
     */
    private void fillRelationship(List<BusinessDomain> domainList, List<BusinessDomainRelationship> relationshipList) {
        Map<String, BusinessDomain> domainMap = domainList.stream().collect(
                Collectors.toMap(e -> e.getDomainAlias(), e -> e));
        for (BusinessDomainRelationship relationship : relationshipList) {
            BusinessDomain domainA = relationship.getRoleA().getDomain();
            BusinessDomain domainB = relationship.getRoleB().getDomain();
            if (Objects.isNull(domainA.getDomainCode())) {
                domainA.setDomainCode(domainMap.get(domainA.getDomainAlias()).getDomainCode());
            }
            if (Objects.isNull(domainB.getDomainCode())) {
                domainB.setDomainCode(domainMap.get(domainB.getDomainAlias()).getDomainCode());
            }
        }
    }

    @Override
    @Validator(beanName = "businessCmdReqDTOValidator", method = "v4AddDomain")
    public Result<Boolean> addDomain(BusinessCmdReqDTO businessCmdReqDTO) {
        Business business = businessService.queryBusiness(businessCmdReqDTO.getBusiness());
        BusinessCheckUtil.checkNull(business, BizCodeEnum.BUSINESS_NOT_EXIST);
        BusinessDomain domain = domainService.queryDomain(businessCmdReqDTO.getDomain());
        BusinessCheckUtil.checkNull(domain, BizCodeEnum.DOMAIN_NOT_EXIST);
        return ResultUtil.success(businessService.addDomain(businessCmdReqDTO.getBusiness(), businessCmdReqDTO.getDomain()));
    }

    @Override
    @Validator(beanName = "businessCmdReqDTOValidator", method = "v4DelDomain")
    public Result<Boolean> delDomain(BusinessCmdReqDTO businessCmdReqDTO) {
        Business business = businessService.queryBusiness(businessCmdReqDTO.getBusiness());
        BusinessCheckUtil.checkNull(business, BizCodeEnum.BUSINESS_NOT_EXIST);
        BusinessDomain domain = domainService.queryDomain(businessCmdReqDTO.getDomain());
        BusinessCheckUtil.checkNull(domain, BizCodeEnum.DOMAIN_NOT_EXIST);
        List<BusinessDomainRelation> businessDomainRelationList = businessService.queryBusinessDomainRelation(business, domain);
        BusinessCheckUtil.checkNonNull(businessDomainRelationList, BizCodeEnum.DOMAIN_HAS_RELATION);
        return ResultUtil.success(businessService.delDomain(businessCmdReqDTO.getBusiness(), businessCmdReqDTO.getDomain()));
    }

    @Override
    @Validator(beanName = "businessCmdReqDTOValidator", method = "v4BuildDomainRelation")
    public Result<Boolean> buildDomainRelation(BusinessCmdReqDTO businessCmdReqDTO) {
        Business business = businessService.queryBusiness(businessCmdReqDTO.getBusiness());
        BusinessCheckUtil.checkNull(business, BizCodeEnum.BUSINESS_NOT_EXIST);
        BusinessDomain domainA = domainService.queryDomain(businessCmdReqDTO.getRelationship().getRoleA().getDomain());
        BusinessCheckUtil.checkNull(domainA, BizCodeEnum.DOMAIN_NOT_EXIST);
        BusinessDomain domainB = domainService.queryDomain(businessCmdReqDTO.getRelationship().getRoleB().getDomain());
        BusinessCheckUtil.checkNull(domainB, BizCodeEnum.DOMAIN_NOT_EXIST);
        BusinessRelDomain businessRelDomain = businessService.queryBusinessRelDomain(business, domainA);
        BusinessCheckUtil.checkNull(businessRelDomain, BizCodeEnum.BUSINESS_REL_DOMAIN_NOT_EXIST);
        businessRelDomain = businessService.queryBusinessRelDomain(business, domainB);
        BusinessCheckUtil.checkNull(businessRelDomain, BizCodeEnum.BUSINESS_REL_DOMAIN_NOT_EXIST);
        return ResultUtil.success(businessDomainDesign4Strategy.buildBusinessDomainRelationship(businessCmdReqDTO.getRelationship()));
    }

    @Override
    @Validator(beanName = "businessCmdReqDTOValidator", method = "v4RemoveDomainRelation")
    public Result<Boolean> removeDomainRelation(BusinessCmdReqDTO businessCmdReqDTO) {
        Business business = businessService.queryBusiness(businessCmdReqDTO.getBusiness());
        BusinessCheckUtil.checkNull(business, BizCodeEnum.BUSINESS_NOT_EXIST);
        BusinessDomain domainA = domainService.queryDomain(businessCmdReqDTO.getRelationship().getRoleA().getDomain());
        BusinessCheckUtil.checkNull(domainA, BizCodeEnum.DOMAIN_NOT_EXIST);
        BusinessDomain domainB = domainService.queryDomain(businessCmdReqDTO.getRelationship().getRoleB().getDomain());
        BusinessCheckUtil.checkNull(domainB, BizCodeEnum.DOMAIN_NOT_EXIST);
        return ResultUtil.success(businessDomainDesign4Strategy.removeBusinessDomainRelationship(businessCmdReqDTO.getRelationship()));
    }

    @Override
    @Validator(beanName = "businessCmdReqDTOValidator", method = "v4AddRole")
    public Result<Boolean> addRole(BusinessCmdReqDTO businessCmdReqDTO) {
        Business business = businessService.queryBusiness(businessCmdReqDTO.getBusiness());
        BusinessCheckUtil.checkNull(business, BizCodeEnum.BUSINESS_NOT_EXIST);
        businessCmdReqDTO.getBusinessRole().setRoleId(codeSeqGenerator.genSeqByCodeKey(CodeKeyEnum.CODE_KEY_ROLE.getKey()));
        return ResultUtil.success(businessService.addRole(businessCmdReqDTO.getBusiness(), businessCmdReqDTO.getBusinessRole()));
    }

    @Override
    public Result<Boolean> delRole(BusinessCmdReqDTO businessCmdReqDTO) {
        return ResultUtil.success(businessService.delRole(businessCmdReqDTO.getBusiness(), businessCmdReqDTO.getBusinessRole()));
    }
}
