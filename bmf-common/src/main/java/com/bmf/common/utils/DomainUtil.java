package com.bmf.common.utils;

import com.bmf.api.domain.dto.DomainQryReqDTO;
import com.bmf.api.domain.dto.DomainCmdReqDTO;
import com.bmf.base.BusinessDomain;
import com.bmf.base.tactics.EntityRelVO;
import com.bmf.base.tactics.entity.DomainEntity;
import com.bmf.base.tactics.valueobject.DomainValueObject;

/**
 * 领域工具类
 */
public class DomainUtil {

    /**
     * 转换对象
     * @param domainCmdReqDTO
     * @return
     */
    public static BusinessDomain convert(DomainCmdReqDTO domainCmdReqDTO) {
        BusinessDomain businessDomain = new BusinessDomain();
        businessDomain.setDomainCode(domainCmdReqDTO.getBusinessDomain().getDomainCode());
        businessDomain.setDomainName(domainCmdReqDTO.getBusinessDomain().getDomainName());
        businessDomain.setDomainAlias(domainCmdReqDTO.getBusinessDomain().getDomainAlias());
        businessDomain.setDomainLevel(domainCmdReqDTO.getBusinessDomain().getDomainLevel());
        businessDomain.setDomainType(domainCmdReqDTO.getBusinessDomain().getDomainType());
        return businessDomain;
    }

    /**
     * 转换对象
     * @param domainQryReqDTO
     * @return
     */
    public static BusinessDomain convert(DomainQryReqDTO domainQryReqDTO) {
        BusinessDomain businessDomain = new BusinessDomain();
        businessDomain.setDomainCode(domainQryReqDTO.getBusinessDomain().getDomainCode());
        businessDomain.setDomainName(domainQryReqDTO.getBusinessDomain().getDomainName());
        businessDomain.setDomainAlias(domainQryReqDTO.getBusinessDomain().getDomainAlias());
        businessDomain.setDomainLevel(domainQryReqDTO.getBusinessDomain().getDomainLevel());
        businessDomain.setDomainType(domainQryReqDTO.getBusinessDomain().getDomainType());
        return businessDomain;
    }

    public static EntityRelVO build(DomainEntity entity, DomainValueObject valueObject) {
        EntityRelVO entityRelVO = new EntityRelVO();
        entityRelVO.setEntityIdCode(entity.getEntityIdCode());
        entityRelVO.setVoCode(valueObject.getVoCode());
        return entityRelVO;
    }
}
