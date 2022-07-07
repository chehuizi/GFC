package com.bmf.infrastructure.dal.utils;

import com.bmf.api.domain.DomainReqDTO;
import com.bmf.infrastructure.dal.po.DomainPO;

public class DomainPOUtil {

    public static DomainPO convert(DomainReqDTO domainReqDTO) {
        DomainPO domainPO = new DomainPO();
        domainPO.setDomainCode(domainReqDTO.getBusinessDomain().getDomainCode());
        domainPO.setDomainName(domainReqDTO.getBusinessDomain().getDomainName());
        domainPO.setDomainType(domainReqDTO.getBusinessDomain().getDomainType());
        domainPO.setDomainLevel(domainReqDTO.getBusinessDomain().getDomainLevel());
        return domainPO;
    }
}
