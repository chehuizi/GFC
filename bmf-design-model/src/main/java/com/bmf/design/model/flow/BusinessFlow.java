package com.bmf.design.model.flow;

import com.bmf.common.model.BaseModel;
import lombok.Builder;
import lombok.Data;

import java.util.List;

/**
 * 业务流程
 */
@Builder
@Data
public class BusinessFlow extends BaseModel {

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
    /**
     * 中间节点列表
     */
    private List<BusinessFlowNode> nodeList;

}
