package com.chz.bmf.base.flow.node;

import com.chz.bmf.base.flow.line.Line;
import lombok.Data;

import java.util.List;

/**
 * 节点基类
 */
@Data
public class NodeBase {

    /**
     * 节点名称
     */
    private String name;
    /**
     * 线列表
     */
    private List<Line> lineList;

}
