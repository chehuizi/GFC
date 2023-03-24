package com.bmf.demo;

import com.bmf.base.annotations.BusinessDomain;

/**
 * 启动类
 */
@BusinessDomain(domainCode = 101, domainAlias = "wms")
public class App {

    public static void main(String args[]) {
        System.out.println("Hello world!");
    }
}
