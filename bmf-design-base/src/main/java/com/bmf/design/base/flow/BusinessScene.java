package com.bmf.design.base.flow;

import lombok.Data;

/**
 * 业务场景
 */
@Data
public class BusinessScene {

    /**
     * 场景名称（中文）
     */
    private String sceneName;
    /**
     * 场景别名（英文）
     */
    private String sceneAlias;
}
