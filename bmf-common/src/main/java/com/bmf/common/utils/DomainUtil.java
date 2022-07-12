package com.bmf.common.utils;

import com.bmf.api.domain.DomainReqDTO;
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

    public static BusinessDomain convert(DomainReqDTO domainReqDTO) {
        BusinessDomain businessDomain = new BusinessDomain();
        businessDomain.setDomainCode(domainReqDTO.getBusinessDomain().getDomainCode());
        businessDomain.setDomainName(domainReqDTO.getBusinessDomain().getDomainName());
        businessDomain.setDomainLevel(domainReqDTO.getBusinessDomain().getDomainLevel());
        businessDomain.setDomainType(domainReqDTO.getBusinessDomain().getDomainType());
        return businessDomain;
    }
}
