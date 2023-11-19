package com.bmf.design.api.validator;

import com.bmf.design.api.domain.dto.DomainEntityQryReqDTO;
import com.bmf.design.api.domain.dto.DomainEntityCmdReqDTO;
import com.bmf.common.utils.checker.ParamCheckUtil;
import org.springframework.stereotype.Service;

@Service("domainEntityReqDTOValidator")
public class DomainEntityReqDTOValidator {

    /**
     * 校验queryOne方法
     * @param domainEntityQryReqDTO
     * @return
     */
    public boolean v4QueryOne(DomainEntityQryReqDTO domainEntityQryReqDTO) {
        ParamCheckUtil.checkNull(domainEntityQryReqDTO, "param is null");
        ParamCheckUtil.checkNull(domainEntityQryReqDTO.getDomainEntity(), "domain entity is null");
        ParamCheckUtil.checkNull(domainEntityQryReqDTO.getDomainEntity().getDomainCode(), "domain code is null");
        ParamCheckUtil.checkNull(domainEntityQryReqDTO.getDomainEntity().getEntityIdCode(), "entity id code is null");
        return true;
    }

    /**
     * 校验addEntityAttr方法
     * @param domainEntityCmdReqDTO
     * @return
     */
    public boolean v4AddEntityAttr(DomainEntityCmdReqDTO domainEntityCmdReqDTO) {
        ParamCheckUtil.checkNull(domainEntityCmdReqDTO, "param is null");
        ParamCheckUtil.checkNull(domainEntityCmdReqDTO.getDomainEntity(), "domain entity is null");
        ParamCheckUtil.checkNull(domainEntityCmdReqDTO.getDomainEntity().getEntityIdCode(), "entity id code is null");
        ParamCheckUtil.checkNull(domainEntityCmdReqDTO.getEntityAttr(), "entity attr is null");
        ParamCheckUtil.checkBlank(domainEntityCmdReqDTO.getEntityAttr().getAttrName(), "entity attr name is blank");
        ParamCheckUtil.checkBlank(domainEntityCmdReqDTO.getEntityAttr().getAttrType(), "entity attr type is blank");
        ParamCheckUtil.checkBlank(domainEntityCmdReqDTO.getEntityAttr().getAttrDesc(), "entity attr desc is blank");
        return true;
    }

    /**
     * 校验delEntityAttr方法
     * @param domainEntityCmdReqDTO
     * @return
     */
    public boolean v4DelEntityAttr(DomainEntityCmdReqDTO domainEntityCmdReqDTO) {
        ParamCheckUtil.checkNull(domainEntityCmdReqDTO, "param is null");
        ParamCheckUtil.checkNull(domainEntityCmdReqDTO.getEntityAttr(), "entity attr is null");
        ParamCheckUtil.checkNull(domainEntityCmdReqDTO.getEntityAttr().getEntityIdCode(), "entity id code is null");
        ParamCheckUtil.checkBlank(domainEntityCmdReqDTO.getEntityAttr().getAttrName(), "entity attr name is blank");
        return true;
    }
}


