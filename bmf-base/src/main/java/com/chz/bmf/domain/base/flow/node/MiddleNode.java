package com.chz.bmf.domain.base.flow.node;

import lombok.Data;

/**
 * 过程节点
 */
@Data
public class MiddleNode extends NodeBase {

    /**
     * 是否暂停
     */
    private boolean paused;

}
