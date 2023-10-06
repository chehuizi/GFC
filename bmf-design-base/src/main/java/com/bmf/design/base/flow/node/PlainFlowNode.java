package com.bmf.design.base.flow.node;

import com.bmf.design.base.enums.BusinessFlowNodeTypeEnum;
import com.bmf.design.base.flow.BusinessFlowNode;
import lombok.Data;

@Data
public class PlainFlowNode extends BusinessFlowNode {

    public PlainFlowNode() {
        this.setNodeType(BusinessFlowNodeTypeEnum.PLAIN.getType());
    }
}
