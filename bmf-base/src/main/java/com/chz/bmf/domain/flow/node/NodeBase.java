package com.chz.bmf.domain.flow.node;

import com.chz.bmf.domain.flow.line.Line;
import com.chz.bmf.domain.flow.processor.Processor;
import lombok.Data;

import java.util.List;

/**
 * 节点基类
 */
@Data
public abstract class NodeBase<T> {

    /**
     * 节点名称
     */
    private String name;
    /**
     * 原子能力
     */
    private Processor<T> processor;
    /**
     * 线列表
     */
    private List<Line<T>> lineList;

}
