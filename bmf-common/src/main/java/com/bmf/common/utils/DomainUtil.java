package com.bmf.common.utils;

import com.bmf.api.domain.dto.DomainQryReqDTO;
import com.bmf.api.domain.dto.DomainReqDTO;
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
     * @param domainReqDTO
     * @return
     */
    public static BusinessDomain convert(DomainReqDTO domainReqDTO) {
        BusinessDomain businessDomain = new BusinessDomain();
        businessDomain.setDomainCode(domainReqDTO.getBusinessDomain().getDomainCode());
        businessDomain.setDomainName(domainReqDTO.getBusinessDomain().getDomainName());
        businessDomain.setDomainAlias(domainReqDTO.getBusinessDomain().getDomainAlias());
        businessDomain.setDomainLevel(domainReqDTO.getBusinessDomain().getDomainLevel());
        businessDomain.setDomainType(domainReqDTO.getBusinessDomain().getDomainType());
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
