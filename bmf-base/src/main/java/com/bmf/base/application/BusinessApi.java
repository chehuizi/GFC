package com.bmf.base.application;

import com.bmf.base.BaseModel;
import lombok.Data;

/**
 * 业务API
 */
@Data
public class BusinessApi extends BaseModel {

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
