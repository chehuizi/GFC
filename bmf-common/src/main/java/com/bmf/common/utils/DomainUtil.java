package com.bmf.common.utils;

import com.bmf.api.domain.DomainReqDTO;
import com.bmf.base.BusinessDomain;
import com.bmf.base.tactics.DomainRelEntity;
import com.bmf.base.tactics.DomainRelService;
import com.bmf.base.tactics.EntityRelVO;
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

    public static DomainRelEntity build(BusinessDomain domain, BusinessDomainEntity entity) {
        DomainRelEntity domainRelEntity = new DomainRelEntity();
        domainRelEntity.setDomainCode(domain.getDomainCode());
        domainRelEntity.setEntityIdCode(entity.getEntityIdCode());
        return domainRelEntity;
    }

    public static DomainRelService build(BusinessDomain domain, BusinessDomainService service) {
        DomainRelService domainRelService = new DomainRelService();
        domainRelService.setDomainCode(domain.getDomainCode());
        domainRelService.setServiceCode(service.getServiceCode());
        return domainRelService;
    }

    public static EntityRelVO build(BusinessDomainEntity entity, BusinessDomainValueObject valueObject) {
        EntityRelVO entityRelVO = new EntityRelVO();
        entityRelVO.setEntityIdCode(entity.getEntityIdCode());
        entityRelVO.setVoCode(valueObject.getVoCode());
        return entityRelVO;
    }
}
