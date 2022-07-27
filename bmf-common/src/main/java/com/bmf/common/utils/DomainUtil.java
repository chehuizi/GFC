package com.bmf.common.utils;

import com.bmf.api.domain.DomainReqDTO;
import com.bmf.base.BusinessDomain;
import com.bmf.base.DO.DomainRelEntityDO;
import com.bmf.base.tactics.entity.BusinessDomainEntity;

/**
 * 领域工具类
 */
public class DomainUtil {

    public static BusinessDomain convert(DomainReqDTO domainReqDTO) {
        BusinessDomain businessDomain = new BusinessDomain();
        businessDomain.setDomainCode(domainReqDTO.getBusinessDomain().getDomainCode());
        businessDomain.setDomainName(domainReqDTO.getBusinessDomain().getDomainName());
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
}
