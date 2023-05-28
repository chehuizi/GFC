package com.bmf.api.validator;

import com.bmf.api.business.dto.BusinessCmdReqDTO;
import com.bmf.base.strategy.BusinessDomainRelationship;
import com.bmf.common.utils.ParamCheckUtil;
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
                && businessCmdReqDTO.getDomainList().size() > 0, "domain list is empty");
        ParamCheckUtil.checkTrue(Objects.nonNull(businessCmdReqDTO.getRelationshipList())
                && businessCmdReqDTO.getRelationshipList().size() > 0, "domain relationship list is empty");
        return true;
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
        ParamCheckUtil.checkBlank(businessCmdReqDTO.getDomain().getPosition(), "domain position is blank");
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
    private void checkDomainRelation(BusinessDomainRelationship relationship) {
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
