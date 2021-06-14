package com.chz.bmf.base.flow.line;

import lombok.Data;

@Data
public abstract class LineBaseCondition<T> implements LineCondition<T> {

    /**
     * 条件值
     */
    private T val;
}
