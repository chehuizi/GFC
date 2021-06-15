package com.chz.bmf.domain.flow.line;

/**
 * 字符串条件
 */
public class LineStringCondition extends LineBaseCondition<String> {

    @Override
    public boolean check(String output) {
        return this.getVal().equals(output);
    }
}
