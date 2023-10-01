package com.bmf.design.api.validator;

import com.bmf.design.api.business.dto.BusinessCmdReqDTO;
import com.bmf.design.base.Domain;
import com.bmf.design.base.enums.DomainTypeEnum;
import com.bmf.design.base.enums.RelationshipEnum;
import com.bmf.design.base.enums.RelationshipRoleEnum;
import com.bmf.design.base.strategy.DomainRelationship;
import com.bmf.design.common.utils.ParamCheckUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service("businessCmdReqDTOValidator")
public class BusinessCmdReqDTOValidator {

    /**
     * 校验create方法
     * @param businessCmdReqDTO
     * @return
     */
    public boolean v4Create(BusinessCmdReqDTO businessCmdReqDTO) {
        ParamCheckUtil.checkNull(businessCmdReqDTO, "param is null");
        ParamCheckUtil.checkNull(businessCmdReqDTO.getBusiness(), "business is null");
        ParamCheckUtil.checkBlank(businessCmdReqDTO.getBusiness().getBusinessPrefix(), "business prefix is blank");
        ParamCheckUtil.checkBlank(businessCmdReqDTO.getBusiness().getBusinessAlias(), "business alias is blank");
        ParamCheckUtil.checkBlank(businessCmdReqDTO.getBusiness().getBusinessName(), "business name is blank");
        ParamCheckUtil.checkBlank(businessCmdReqDTO.getBusiness().getBusinessDesc(), "business description is blank");
        return true;
    }

    public boolean v4Update(BusinessCmdReqDTO businessCmdReqDTO) {
        ParamCheckUtil.checkNull(businessCmdReqDTO, "param is null");
        ParamCheckUtil.checkNull(businessCmdReqDTO.getBusiness(), "business is null");
        ParamCheckUtil.checkNull(businessCmdReqDTO.getBusiness().getBusinessCode(), "business code is null");
        ParamCheckUtil.checkTrue(StringUtils.isNotBlank(businessCmdReqDTO.getBusiness().getBusinessDesc())
                                || StringUtils.isNotBlank(businessCmdReqDTO.getBusiness().getBusinessName()),
                        "no param to update");
        return true;
    }

    /**
     * 校验saveStrategyDesign方法
     * @param businessCmdReqDTO
     * @return
     */
    public boolean v4SaveStrategyDesign(BusinessCmdReqDTO businessCmdReqDTO) {
        ParamCheckUtil.checkNull(businessCmdReqDTO, "param is null");
        ParamCheckUtil.checkNull(businessCmdReqDTO.getBusiness(), "business is null");
        ParamCheckUtil.checkNull(businessCmdReqDTO.getBusiness().getBusinessCode(), "business code is null");
        ParamCheckUtil.checkTrue(Objects.nonNull(businessCmdReqDTO.getDomainList())
                && !businessCmdReqDTO.getDomainList().isEmpty(), "domain list is empty");
        for (Domain domain : businessCmdReqDTO.getDomainList()) {
            checkDomain(domain);
        }
        for (DomainRelationship relationship : businessCmdReqDTO.getRelationshipList()) {
            checkRelationship(relationship);
        }
        return true;
    }

    /**
     * 校验领域
     * @param domain
     */
    private void checkDomain(Domain domain) {
        ParamCheckUtil.checkNull(domain.getDomainCode(), "domain code is null");
        ParamCheckUtil.checkBlank(domain.getDomainAlias(), "domain alias is blank");
        ParamCheckUtil.checkBlank(domain.getDomainName(), "domain name is blank");
        ParamCheckUtil.checkBlank(domain.getDomainType(), "domain type is blank");
        ParamCheckUtil.checkNull(DomainTypeEnum.getByType(domain.getDomainType()), "domain type is not enum");
        ParamCheckUtil.checkBlank(domain.getDomainPosition(), "domain position is blank");
        /*
        DomainPosition domainPosition = JSON.parseObject(domain.getDomainPosition(), DomainPosition.class);
        ParamCheckUtil.checkTrue(domainPosition.getX() > 0, "domain position X is not positive integer");
        ParamCheckUtil.checkTrue(domainPosition.getY() > 0, "domain position Y is not positive integer");
        */
    }

    /**
     * 校验领域关系
     * @param relationship
     */
    private void checkRelationship(DomainRelationship relationship) {
        ParamCheckUtil.checkBlank(relationship.getRelationship(), "relationship is blank");
        ParamCheckUtil.checkNull(RelationshipEnum.getByType(relationship.getRelationship()), "relationship is not enum");

        ParamCheckUtil.checkNull(relationship.getRoleA(), "relationship role A is null");
        ParamCheckUtil.checkNull(relationship.getRoleA().getDomain(), "relationship role A domain is null");
        ParamCheckUtil.checkNull(relationship.getRoleA().getDomain().getDomainCode(), "relationship role A domain code is null");
//        ParamCheckUtil.checkBlank(relationship.getRoleA().getDomain().getDomainAlias(), "relationship role A domain alias is blank");
        ParamCheckUtil.checkBlank(relationship.getRoleA().getRole(), "relationship role A is blank");
        ParamCheckUtil.checkNull(RelationshipRoleEnum.getByRole(relationship.getRoleA().getRole()), "relationship role A is not enum");

        ParamCheckUtil.checkNull(relationship.getRoleB(), "relationship role B is null");
        ParamCheckUtil.checkNull(relationship.getRoleB().getDomain(), "relationship role B domain is null");
        ParamCheckUtil.checkNull(relationship.getRoleB().getDomain().getDomainCode(), "relationship role B domain code is null");
//        ParamCheckUtil.checkBlank(relationship.getRoleB().getDomain().getDomainAlias(), "relationship role B domain alias is blank");
        ParamCheckUtil.checkBlank(relationship.getRoleB().getRole(), "relationship role B is blank");
        ParamCheckUtil.checkNull(RelationshipRoleEnum.getByRole(relationship.getRoleB().getRole()), "relationship role B is not enum");
    }

    /**
     * 校验addDomain方法
     * @param businessCmdReqDTO
     * @return
     */
    public boolean v4AddDomain(BusinessCmdReqDTO businessCmdReqDTO) {
        ParamCheckUtil.checkNull(businessCmdReqDTO, "param is null");
        ParamCheckUtil.checkNull(businessCmdReqDTO.getBusiness(), "business is null");
        ParamCheckUtil.checkNull(businessCmdReqDTO.getBusiness().getBusinessCode(), "business code is null");
        ParamCheckUtil.checkNull(businessCmdReqDTO.getDomain(), "domain is null");
        ParamCheckUtil.checkNull(businessCmdReqDTO.getDomain().getDomainCode(), "domain code is null");
        ParamCheckUtil.checkBlank(businessCmdReqDTO.getDomain().getDomainPosition(), "domain position is blank");
        return true;
    }

    /**
     * 校验delDomain方法
     * @return
     */
    public boolean v4DelDomain(BusinessCmdReqDTO businessCmdReqDTO) {
        ParamCheckUtil.checkNull(businessCmdReqDTO, "param is null");
        ParamCheckUtil.checkNull(businessCmdReqDTO.getBusiness(), "business is null");
        ParamCheckUtil.checkNull(businessCmdReqDTO.getDomain(), "domain is null");
        return true;
    }

    /**
     * 校验buildDomainRelation方法
     * @param businessCmdReqDTO
     * @return
     */
    public boolean v4BuildDomainRelation(BusinessCmdReqDTO businessCmdReqDTO) {
        ParamCheckUtil.checkNull(businessCmdReqDTO, "param is null");
        checkDomainRelation(businessCmdReqDTO.getRelationship());
        return true;
    }

    /**
     * 校验removeDomainRelation方法
     * @param businessCmdReqDTO
     * @return
     */
    public boolean v4RemoveDomainRelation(BusinessCmdReqDTO businessCmdReqDTO) {
        ParamCheckUtil.checkNull(businessCmdReqDTO, "param is null");
        checkDomainRelation(businessCmdReqDTO.getRelationship());
        return true;
    }

    /**
     * 校验addRole方法
     * @param businessCmdReqDTO
     * @return
     */
    public boolean v4AddRole(BusinessCmdReqDTO businessCmdReqDTO) {
        ParamCheckUtil.checkNull(businessCmdReqDTO, "param is null");
        ParamCheckUtil.checkNull(businessCmdReqDTO.getBusiness(), "business is null");
        ParamCheckUtil.checkNull(businessCmdReqDTO.getBusiness().getBusinessCode(), "business code is null");
        ParamCheckUtil.checkNull(businessCmdReqDTO.getBusinessRole(), "business role is null");
        ParamCheckUtil.checkTrue(businessCmdReqDTO.getBusiness().getBusinessCode().equals(
                businessCmdReqDTO.getBusinessRole().getBusinessCode()), "business code is not equal");
        return true;
    }

    /**
     * 校验BusinessDomainRelationship参数
     * @param relationship
     */
    private void checkDomainRelation(DomainRelationship relationship) {
        ParamCheckUtil.checkNull(relationship, "relationship is null");
        ParamCheckUtil.checkNull(relationship.getBusinessCode(), "business code is null");
        ParamCheckUtil.checkBlank(relationship.getRelationship(), "relationship is blank");
        ParamCheckUtil.checkNull(relationship.getRoleA(), "roleA is null");
        ParamCheckUtil.checkNull(relationship.getRoleB(), "roleB is null");
        ParamCheckUtil.checkNull(relationship.getRoleA().getDomain(), "roleA's domain is null");
        ParamCheckUtil.checkNull(relationship.getRoleA().getDomain().getDomainCode(), "roleA's domain code is null");
        ParamCheckUtil.checkBlank(relationship.getRoleA().getRole(), "roleA's role is blank");
        ParamCheckUtil.checkNull(relationship.getRoleB().getDomain(), "roleB's domain is null");
        ParamCheckUtil.checkNull(relationship.getRoleA().getDomain().getDomainCode(), "roleB's domain code is null");
        ParamCheckUtil.checkBlank(relationship.getRoleB().getRole(), "roleB's role is blank");
    }
}
