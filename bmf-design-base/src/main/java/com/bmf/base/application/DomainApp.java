package com.bmf.base.application;

import com.bmf.base.BaseModel;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 业务应用
 */
@Data
public class DomainApp extends BaseModel {

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
     * 领域编码
     */
    private Integer domainCode;
    /**
     * 领域别名（英文）
     */
    private String domainAlias;

}
