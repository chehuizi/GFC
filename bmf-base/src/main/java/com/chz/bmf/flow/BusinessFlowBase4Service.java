package com.chz.bmf.flow;


import com.chz.bmf.common.BusinessDomainNameEnum;
import com.chz.bmf.service.BusinessService4Domain;
import lombok.Data;

@Data
public abstract class BusinessFlowBase4Service implements BusinessService4Domain {

    /**
     * 领域
     */
    private BusinessDomainNameEnum domainName;

}
