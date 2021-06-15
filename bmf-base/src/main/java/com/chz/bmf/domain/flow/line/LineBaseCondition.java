package com.chz.bmf.domain.flow.line;

import lombok.Data;

@Data
public abstract class LineBaseCondition<T> implements LineCondition<T> {

    /**
     * 条件值
     */
    private T val;
}
