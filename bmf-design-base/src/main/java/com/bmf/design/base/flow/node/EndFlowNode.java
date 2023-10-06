package com.bmf.design.base.flow.node;

import com.bmf.design.base.enums.BusinessFlowNodeTypeEnum;
import com.bmf.design.base.flow.BusinessFlowNode;
import lombok.Data;

/**
 * 结束节点
 */
@Data
public class EndFlowNode extends BusinessFlowNode {

    public EndFlowNode() {
        this.setNodeType(BusinessFlowNodeTypeEnum.END.getType());
    }
}
