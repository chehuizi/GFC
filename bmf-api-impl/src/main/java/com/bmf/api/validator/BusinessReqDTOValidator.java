package com.bmf.api.validator;

import com.bmf.api.business.BusinessReqDTO;
import com.bmf.base.strategy.BusinessDomainRelationship;
import com.bmf.common.utils.ParamCheckUtil;
import org.springframework.stereotype.Service;

@Service("businessReqDTOValidator")
public class BusinessReqDTOValidator {

    /**
     * 校验create方法
     * @param businessReqDTO
     * @return
     */
    public boolean v4Create(BusinessReqDTO businessReqDTO) {
        ParamCheckUtil.checkNull(businessReqDTO, "param is null");
        ParamCheckUtil.checkNull(businessReqDTO.getBusiness(), "business is null");
        return true;
    }

    /**
     * 校验addDomain方法
     * @param businessReqDTO
     * @return
     */
    public boolean v4AddDomain(BusinessReqDTO businessReqDTO) {
        ParamCheckUtil.checkNull(businessReqDTO, "param is null");
        ParamCheckUtil.checkNull(businessReqDTO.getBusiness(), "business is null");
        ParamCheckUtil.checkNull(businessReqDTO.getDomain(), "domain is null");
        return true;
    }

    /**
     * 校验delDomain方法
     * @return
     */
    public boolean v4DelDomain(BusinessReqDTO businessReqDTO) {
        ParamCheckUtil.checkNull(businessReqDTO, "param is null");
        ParamCheckUtil.checkNull(businessReqDTO.getBusiness(), "business is null");
        ParamCheckUtil.checkNull(businessReqDTO.getDomain(), "domain is null");
        return true;
    }

    /**
     * 校验buildDomainRelation方法
     * @param businessReqDTO
     * @return
     */
    public boolean v4BuildDomainRelation(BusinessReqDTO businessReqDTO) {
        ParamCheckUtil.checkNull(businessReqDTO, "param is null");
        checkDomainRelation(businessReqDTO.getRelationship());
        return true;
    }

    /**
     * 校验removeDomainRelation方法
     * @param businessReqDTO
     * @return
     */
    public boolean v4RemoveDomainRelation(BusinessReqDTO businessReqDTO) {
        ParamCheckUtil.checkNull(businessReqDTO, "param is null");
        checkDomainRelation(businessReqDTO.getRelationship());
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
