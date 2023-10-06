package com.bmf.design.base.flow.node;

import com.bmf.design.base.enums.BusinessFlowNodeTypeEnum;
import com.bmf.design.base.flow.BusinessFlowNode;
import lombok.Data;

/**
 * 开始节点
 */
@Data
public class StartFlowNode extends BusinessFlowNode {

    public StartFlowNode() {
        this.setNodeType(BusinessFlowNodeTypeEnum.START.getType());
    }
}
