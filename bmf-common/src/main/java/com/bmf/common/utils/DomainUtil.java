package com.bmf.common.utils;

import com.bmf.api.domain.DomainReqDTO;
import com.bmf.base.BusinessDomain;
import com.bmf.base.DO.DomainRelEntityDO;
import com.bmf.base.DO.DomainRelServiceDO;
import com.bmf.base.DO.EntityRelVODO;
import com.bmf.base.tactics.entity.BusinessDomainEntity;
import com.bmf.base.tactics.service.BusinessDomainService;
import com.bmf.base.tactics.valueobject.BusinessDomainValueObject;

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

    public static DomainRelEntityDO build(BusinessDomain domain, BusinessDomainEntity entity) {
        DomainRelEntityDO domainRelEntityDO = new DomainRelEntityDO();
        domainRelEntityDO.setDomainCode(domain.getDomainCode());
        domainRelEntityDO.setEntityIdCode(entity.getEntityIdCode());
        return domainRelEntityDO;
    }

    public static DomainRelServiceDO build(BusinessDomain domain, BusinessDomainService service) {
        DomainRelServiceDO domainRelServiceDO = new DomainRelServiceDO();
        domainRelServiceDO.setDomainCode(domain.getDomainCode());
        domainRelServiceDO.setServiceCode(service.getServiceCode());
        return domainRelServiceDO;
    }

    public static EntityRelVODO build(BusinessDomainEntity entity, BusinessDomainValueObject valueObject) {
        EntityRelVODO entityRelVODO = new EntityRelVODO();
        entityRelVODO.setEntityIdCode(entity.getEntityIdCode());
        entityRelVODO.setVoCode(valueObject.getVoCode());
        return entityRelVODO;
    }
}
