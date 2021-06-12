package com.chz.bmf.base.service;


import com.chz.bmf.base.common.BusinessDomainNameEnum;
import lombok.Data;

@Data
public abstract class BusinessServiceBase4Domain implements BusinessService4Domain {

    /**
     * 领域
     */
    private BusinessDomainNameEnum domainName;

}
