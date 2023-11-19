package com.bmf.dev.model.application;

import com.bmf.common.model.BaseModel;
import lombok.Data;

/**
 * 业务应用
 */
@Data
public class DomainApp extends BaseModel {

    /**
     * 领域编码
     */
    private Integer domainCode;
    /**
     * 领域别名（英文）
     */
    private String domainAlias;
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

}
