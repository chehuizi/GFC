package com.bmf.api.impl.business;

import com.bmf.api.Result;
import com.bmf.api.business.BusinessCmdService;
import com.bmf.api.business.dto.BusinessCmdReqDTO;
import com.bmf.base.Domain;
import com.bmf.base.DomainRelation;
import com.bmf.base.BusinessRelDomain;
import com.bmf.base.enums.CmdTypeEnum;
import com.bmf.base.enums.CodeKeyEnum;
import com.bmf.base.enums.SnapshotObjTypeEnum;
import com.bmf.base.snapshot.DomainStrategyDesignSnapshot;
import com.bmf.base.strategy.DomainRelationship;
import com.bmf.common.enums.BizCodeEnum;
import com.bmf.base.Business;
import com.bmf.common.utils.BusinessCheckUtil;
import com.bmf.common.utils.ResultUtil;
import com.bmf.common.validator.Validator;
import com.bmf.core.business.BusinessService;
import com.bmf.core.design.BusinessDomainDesign4Strategy;
import com.bmf.core.domain.DomainService;
import com.bmf.core.snapshot.SnapshotService;
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
    @Autowired
    private SnapshotService snapshotService;

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
    public Result<Boolean> saveStrategyDesign(BusinessCmdReqDTO businessCmdReqDTO) {
        Business business = businessService.queryBusiness(businessCmdReqDTO.getBusiness());
        BusinessCheckUtil.checkNull(business, BizCodeEnum.BUSINESS_NOT_EXIST);
        // step1：快照
        boolean result = snapshotService(business);
        BusinessCheckUtil.checkTrue(result, BizCodeEnum.STRATEGY_DESIGN_SNAPSHOT_FAILED);

        // step2：处理领域
        Map<CmdTypeEnum, List<Domain>> domainResult = domainService.handleStrategyDesign(business.getBusinessCode(),
                businessCmdReqDTO.getDomainList());

        // step3：处理前端组件ID和领域
        handleViewAndDomain(domainResult, businessCmdReqDTO.getRelationshipList());

        // step4：处理业务和领域关系
        result = businessService.handleStrategyDesign(business, domainResult,
                businessCmdReqDTO.getRelationshipList());

        return ResultUtil.success(result);
    }

    /**
     * 备份
     * @param business
     * @return
     */
    private boolean snapshotService(Business business) {
        // step1 查询
        List<BusinessRelDomain> businessRelDomainList = businessService.queryBusinessRelDomain(business);
        List<Domain> domainList = domainService.queryDomainByCode(businessRelDomainList.stream().
                map(BusinessRelDomain::getDomainCode).collect(Collectors.toList()));
        List<DomainRelation> domainRelationList = businessService.queryBusinessDomainRelation(business);
        DomainStrategyDesignSnapshot snapshot = DomainStrategyDesignSnapshot.builder()
                .domainList(domainList)
                .businessRelDomainList(businessRelDomainList)
                .domainRelationList(domainRelationList)
                .build();
        snapshot.setObjId(business.getBusinessCode().toString());
        snapshot.setObjType(SnapshotObjTypeEnum.DOMAIN_STRATEGY.getObjType());

        // step2 备份
        return snapshotService.snapshot(snapshot);
    }

    /**
     * 处理
     * @param domainResult
     * @param relationshipList
     */
    private void handleViewAndDomain(Map<CmdTypeEnum, List<Domain>> domainResult,
                                     List<DomainRelationship> relationshipList) {
        List<Domain> insertedDomains = domainResult.get(CmdTypeEnum.INSERT);
        Map<String, Domain> insertedDomainMapByAlias = Objects.nonNull(insertedDomains) ?
                insertedDomains.stream().collect(
                        Collectors.toMap(e -> e.getDomainAlias(), e -> e)) : Collections.EMPTY_MAP;
        for (DomainRelationship relationship : relationshipList) {
            String domainAlias = relationship.getRoleA().getDomain().getDomainAlias();
            Integer domainCode = relationship.getRoleA().getDomain().getDomainCode();
            if (Objects.nonNull(insertedDomainMapByAlias.get(domainAlias)) &&
                    !insertedDomainMapByAlias.get(domainAlias).getDomainCode().equals(domainCode)) {
                relationship.getRoleA().getDomain().setDomainCode(insertedDomainMapByAlias.get(domainAlias).getDomainCode());
            }

            domainAlias = relationship.getRoleB().getDomain().getDomainAlias();
            domainCode = relationship.getRoleB().getDomain().getDomainCode();
            if (Objects.nonNull(insertedDomainMapByAlias.get(domainAlias)) &&
                    !insertedDomainMapByAlias.get(domainAlias).getDomainCode().equals(domainCode)) {
                relationship.getRoleB().getDomain().setDomainCode(insertedDomainMapByAlias.get(domainAlias).getDomainCode());
            }
        }
    }

    @Override
    @Validator(beanName = "businessCmdReqDTOValidator", method = "v4SaveStrategyDesign")
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED)
    public Result<Boolean> saveStrategyDesignV2(BusinessCmdReqDTO businessCmdReqDTO) {
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
    private void fillRelationship(List<Domain> domainList, List<DomainRelationship> relationshipList) {
        Map<String, Domain> domainMap = domainList.stream().collect(
                Collectors.toMap(e -> e.getDomainAlias(), e -> e));
        for (DomainRelationship relationship : relationshipList) {
            Domain domainA = relationship.getRoleA().getDomain();
            Domain domainB = relationship.getRoleB().getDomain();
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
        Domain domain = domainService.queryDomain(businessCmdReqDTO.getDomain());
        BusinessCheckUtil.checkNull(domain, BizCodeEnum.DOMAIN_NOT_EXIST);
        return ResultUtil.success(businessService.addDomain(businessCmdReqDTO.getBusiness(), businessCmdReqDTO.getDomain()));
    }

    @Override
    @Validator(beanName = "businessCmdReqDTOValidator", method = "v4DelDomain")
    public Result<Boolean> delDomain(BusinessCmdReqDTO businessCmdReqDTO) {
        Business business = businessService.queryBusiness(businessCmdReqDTO.getBusiness());
        BusinessCheckUtil.checkNull(business, BizCodeEnum.BUSINESS_NOT_EXIST);
        Domain domain = domainService.queryDomain(businessCmdReqDTO.getDomain());
        BusinessCheckUtil.checkNull(domain, BizCodeEnum.DOMAIN_NOT_EXIST);
        List<DomainRelation> domainRelationList = businessService.queryBusinessDomainRelation(business, domain);
        BusinessCheckUtil.checkNonNull(domainRelationList, BizCodeEnum.DOMAIN_HAS_RELATION);
        return ResultUtil.success(businessService.delDomain(businessCmdReqDTO.getBusiness(), businessCmdReqDTO.getDomain()));
    }

    @Override
    @Validator(beanName = "businessCmdReqDTOValidator", method = "v4BuildDomainRelation")
    public Result<Boolean> buildDomainRelation(BusinessCmdReqDTO businessCmdReqDTO) {
        Business business = businessService.queryBusiness(businessCmdReqDTO.getBusiness());
        BusinessCheckUtil.checkNull(business, BizCodeEnum.BUSINESS_NOT_EXIST);
        Domain domainA = domainService.queryDomain(businessCmdReqDTO.getRelationship().getRoleA().getDomain());
        BusinessCheckUtil.checkNull(domainA, BizCodeEnum.DOMAIN_NOT_EXIST);
        Domain domainB = domainService.queryDomain(businessCmdReqDTO.getRelationship().getRoleB().getDomain());
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
        Domain domainA = domainService.queryDomain(businessCmdReqDTO.getRelationship().getRoleA().getDomain());
        BusinessCheckUtil.checkNull(domainA, BizCodeEnum.DOMAIN_NOT_EXIST);
        Domain domainB = domainService.queryDomain(businessCmdReqDTO.getRelationship().getRoleB().getDomain());
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
