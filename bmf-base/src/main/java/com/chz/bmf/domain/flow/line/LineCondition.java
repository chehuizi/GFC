package com.chz.bmf.domain.flow.line;

public interface LineCondition<T> {

    /**
     * 校验条件
     * @param output
     * @return
     */
    boolean check(T output);
}
