package com.bmf.design.infrastructure.dal.po;

import lombok.Data;

@Data
public class BusinessPO extends BasePO {

    /**
     * 业务前缀
     */
    private String businessPrefix;
    /**
     * 业务编码
     */
    private Integer businessCode;
    /**
     * 业务名称（中文）
     */
    private String businessName;
    /**
     * 业务别名（英文）
     */
    private String businessAlias;
    /**
     * 业务描述
     */
    private String businessDesc;
}
