package com.bmf.infrastructure.dal.po;

import lombok.Data;

@Data
public class BusinessPO extends BasePO {

    /**
     * 业务编码
     */
    private Integer businessCode;

    /**
     * 业务名称
     */
    private String businessName;
}
