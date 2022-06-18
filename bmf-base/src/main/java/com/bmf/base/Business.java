package com.bmf.base;

import lombok.Data;

import java.util.List;

/**
 * 业务
 */
@Data
public class Business {

    /**
     * 业务编码
     */
    private Integer businessCode;

    /**
     * 业务名称
     */
    private String businessName;

    /**
     * 业务域
     */
    private List<BusinessDomain> businessDomainList;

    /**
     * 业务域映射
     */
    private BusinessDomainMap businessDomainMap;

}
