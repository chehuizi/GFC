package com.bmf.api.validator;

import com.bmf.api.business.BusinessReqDTO;
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
        ParamCheckUtil.checkNull(businessReqDTO.getRelationship(), "relationship is null");
        ParamCheckUtil.checkNull(businessReqDTO.getRelationship().getBusinessCode(), "business code is null");
        ParamCheckUtil.checkBlank(businessReqDTO.getRelationship().getRelationship(), "relationship is blank");
        ParamCheckUtil.checkNull(businessReqDTO.getRelationship().getRoleA(), "roleA is null");
        ParamCheckUtil.checkNull(businessReqDTO.getRelationship().getRoleB(), "roleB is null");
        ParamCheckUtil.checkNull(businessReqDTO.getRelationship().getRoleA().getDomain(), "roleA's domain is null");
        ParamCheckUtil.checkBlank(businessReqDTO.getRelationship().getRoleA().getRole(), "roleA's role is blank");
        ParamCheckUtil.checkNull(businessReqDTO.getRelationship().getRoleB().getDomain(), "roleB's domain is null");
        ParamCheckUtil.checkBlank(businessReqDTO.getRelationship().getRoleB().getRole(), "roleB's role is blank");
        return true;
    }
}
