package com.bmf.base.flow.line;

public interface LineCondition {

    /**
     * 校验条件
     * @param output
     * @return
     */
    <T> boolean check(T output);
}
