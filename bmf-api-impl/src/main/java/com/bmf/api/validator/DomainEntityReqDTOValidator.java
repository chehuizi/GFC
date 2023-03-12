package com.bmf.api.validator;

import com.bmf.api.domain.dto.DomainEntityQryReqDTO;
import com.bmf.api.domain.dto.DomainEntityReqDTO;
import com.bmf.common.utils.ParamCheckUtil;
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
     * @param domainEntityReqDTO
     * @return
     */
    public boolean v4AddEntityAttr(DomainEntityReqDTO domainEntityReqDTO) {
        ParamCheckUtil.checkNull(domainEntityReqDTO, "param is null");
        ParamCheckUtil.checkNull(domainEntityReqDTO.getDomainEntity(), "domain entity is null");
        ParamCheckUtil.checkNull(domainEntityReqDTO.getDomainEntity().getEntityIdCode(), "entity id code is null");
        ParamCheckUtil.checkNull(domainEntityReqDTO.getEntityAttr(), "entity attr is null");
        ParamCheckUtil.checkBlank(domainEntityReqDTO.getEntityAttr().getAttrName(), "entity attr name is blank");
        ParamCheckUtil.checkBlank(domainEntityReqDTO.getEntityAttr().getAttrType(), "entity attr type is blank");
        ParamCheckUtil.checkBlank(domainEntityReqDTO.getEntityAttr().getAttrDesc(), "entity attr desc is blank");
        return true;
    }

    /**
     * 校验delEntityAttr方法
     * @param domainEntityReqDTO
     * @return
     */
    public boolean v4DelEntityAttr(DomainEntityReqDTO domainEntityReqDTO) {
        ParamCheckUtil.checkNull(domainEntityReqDTO, "param is null");
        ParamCheckUtil.checkNull(domainEntityReqDTO.getEntityAttr(), "entity attr is null");
        ParamCheckUtil.checkNull(domainEntityReqDTO.getEntityAttr().getEntityIdCode(), "entity id code is null");
        ParamCheckUtil.checkBlank(domainEntityReqDTO.getEntityAttr().getAttrName(), "entity attr name is blank");
        return true;
    }
}


