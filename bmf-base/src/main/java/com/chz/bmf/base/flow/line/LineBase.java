package com.chz.bmf.base.flow.line;

import com.chz.bmf.base.flow.node.NodeBase;
import lombok.Data;

@Data
public class LineBase {

    /**
     * 起点
     */
    private NodeBase from;
    /**
     * 终点
     */
    private NodeBase to;
    /**
     * 线条件
     */
    private LineCondition lineCondition;
}
