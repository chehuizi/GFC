package com.bmf.core.utils;

import com.bmf.api.domain.DomainRespDTO;
import com.bmf.base.BusinessDomain;
import com.bmf.infrastructure.dal.po.DomainPO;

/**
 * 领域工具类
 */
public class DomainUtil {

    /**
     * 转换PO到DTO
     * @param domainPO
     * @return
     */
    public static DomainRespDTO convert(DomainPO domainPO) {
        DomainRespDTO domainRespDTO = new DomainRespDTO();
        BusinessDomain businessDomain = new BusinessDomain();
        businessDomain.setDomainName(domainPO.getDomainName());
        businessDomain.setDomainType(domainPO.getDomainType());
        businessDomain.setDomainLevel(domainPO.getDomainLevel());
        domainRespDTO.setBusinessDomain(businessDomain);
        return domainRespDTO;
    }
}
