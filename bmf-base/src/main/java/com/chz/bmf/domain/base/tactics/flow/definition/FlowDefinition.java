package com.chz.bmf.domain.base.tactics.flow.definition;

import com.chz.bmf.domain.base.tactics.flow.line.Line;
import com.chz.bmf.domain.base.tactics.flow.node.EndNode;
import com.chz.bmf.domain.base.tactics.flow.node.MiddleNode;
import com.chz.bmf.domain.base.tactics.flow.node.StartNode;
import lombok.Data;

import java.util.*;

/**
 * 流程定义
 */
@Data
public class FlowDefinition {

    /**
     * 流程ID，唯一标识
     */
    private int flowId;
    /**
     * 流程名称
     */
    private String flowName;
    /**
     * 开始节点
     */
    private StartNode startNode;
    /**
     * 结束节点
     */
    private EndNode endNode;
    /**
     * 中间节点列表
     */
    private List<MiddleNode> middleNodeList;
    /**
     * 线列表
     */
    private List<Line> lineList;
    /**
     * 线Map
     */
    private Map<String, List<Line>> lineMap;

    /**
     * 构建lineMap
     */
    public void buildLineMap() {
        lineMap = new HashMap<>();
        for (Line item : lineList) {
            if (Objects.isNull(lineMap.get(item.getFrom().getName()))) {
                List<Line> lines = new ArrayList<>();
                lineMap.put(item.getFrom().getName(), lines);
            }
            lineMap.get(item.getFrom().getName()).add(item);
        }
    }

}
