package com.chz.bmf.base.flow;


import com.chz.bmf.base.common.BusinessDomainNameEnum;
import com.chz.bmf.base.service.BusinessService4Domain;
import lombok.Data;

@Data
public abstract class BusinessFlowBase4Service implements BusinessService4Domain {

    /**
     * 领域
     */
    private BusinessDomainNameEnum domainName;

}
