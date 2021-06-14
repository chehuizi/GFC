package com.chz.bmf.base.flow.node;

import com.chz.bmf.base.flow.line.LineBase;
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
     * 节点类型
     */
    private String type;
    /**
     * 线列表
     */
    private List<LineBase> lineList;

}
