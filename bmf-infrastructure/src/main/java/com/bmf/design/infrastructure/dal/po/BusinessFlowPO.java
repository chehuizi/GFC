package com.bmf.design.infrastructure.dal.po;

import lombok.Data;


@Data
public class BusinessFlowPO extends BasePO {

    /**
     * 业务编码
     */
    private Integer businessCode;
    /**
     * 场景ID
     */
    private Integer sceneId;
    /**
     * 流程ID
     */
    private Integer flowId;
    /**
     * 流程名称（中文）
     */
    private String flowName;
    /**
     * 流程别名（英文）
     */
    private String flowAlias;
}
