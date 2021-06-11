package com.chz.bmf.service;


import com.chz.bmf.common.BusinessDomainNameEnum;
import lombok.Data;

@Data
public abstract class ServiceBase4BusinessDomain implements Service4BusinessDomain {

    /**
     * 领域
     */
    private BusinessDomainNameEnum domainName;

}
