package com.bmf.design.model.flow;

import com.bmf.common.model.BaseModel;
import lombok.Data;

/**
 * 业务场景
 */
@Data
public class BusinessScene extends BaseModel {

    /**
     * 业务编码
     */
    private Integer businessCode;
    /**
     * 场景ID
     */
    private Integer sceneId;
    /**
     * 场景名称（中文）
     */
    private String sceneName;
    /**
     * 场景别名（英文）
     */
    private String sceneAlias;
    /**
     * 场景描述
     */
    private String sceneDesc;
}
