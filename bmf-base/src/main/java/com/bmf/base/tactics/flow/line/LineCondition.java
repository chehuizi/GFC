package com.bmf.base.tactics.flow.line;

public interface LineCondition {

    /**
     * 校验条件
     * @param output
     * @return
     */
    <T> boolean check(T output);
}
