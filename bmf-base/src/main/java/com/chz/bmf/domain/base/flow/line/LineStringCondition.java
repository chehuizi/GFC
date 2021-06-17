package com.chz.bmf.domain.base.flow.line;

/**
 * 字符串条件
 */
public class LineStringCondition implements LineCondition {

    @Override
    public <T> boolean check(T output) {
        return false;
    }
}
