package com.chz.bmf.domain.flow.line;

import com.chz.bmf.domain.flow.node.NodeBase;
import lombok.Data;

@Data
public class Line<T> {

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
    private LineCondition<T> lineCondition;
}
