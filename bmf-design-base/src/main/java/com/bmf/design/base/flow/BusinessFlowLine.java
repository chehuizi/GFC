package com.bmf.design.base.flow;

import com.bmf.design.base.BaseModel;
import lombok.Data;

/**
 * 业务流程线
 */
@Data
public class BusinessFlowLine extends BaseModel {

    /**
     * 左节点
     */
    private BusinessFlowNode leftNode;
    /**
     * 右节点
     */
    private BusinessFlowNode rightNode;

    public BusinessFlowLine() {
    }

    public BusinessFlowLine(BusinessFlowNode leftNode, BusinessFlowNode rightNode) {
        this.leftNode = leftNode;
        this.rightNode = rightNode;
    }
}
