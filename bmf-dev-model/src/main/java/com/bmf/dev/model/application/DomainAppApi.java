package com.bmf.dev.model.application;

import com.bmf.common.model.BaseModel;
import lombok.Data;

/**
 * 业务API
 */
@Data
public class DomainAppApi extends BaseModel {

    /**
     * 领域编码
     */
    private Integer domainCode;
    /**
     * 领域别名（英文）
     */
    private String domainAlias;
    /**
     * 领域元素类型
     * @see com.bmf.design.model.enums.DomainElementEnum
     */
    private String domainElementType;
    /**
     * 领域元素编码
     */
    private Integer elementCode;
    /**
     * 领域元素别名（英文）
     */
    private String elementAlias;
    /**
     * 应用ID
     */
    private Integer appId;
    /**
     * 应用名称
     */
    private String appName;
    /**
     * 应用描述
     */
    private String appDesc;
    /**
     * API类型
     */
    private String apiType;
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

}
