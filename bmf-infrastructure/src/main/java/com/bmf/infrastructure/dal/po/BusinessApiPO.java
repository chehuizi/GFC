package com.bmf.infrastructure.dal.po;

import lombok.Data;

@Data
public class BusinessApiPO extends BasePO {

    /**
     * API名称
     */
    private String apiName;
    /**
     * API路径
     */
    private String apiPath;
    /**
     * API描述
     */
    private String apiDesc;
    /**
     * 领域服务编码
     */
    private Integer serviceCode;
    /**
     * 领域服务别名（英文）
     */
    private String serviceAlias;
}
