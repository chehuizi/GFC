package com.bmf.demo;

import com.bmf.base.annotations.BusinessApplication;

/**
 * 启动类
 */
@BusinessApplication(domainCode = 101, domainAlias = "wms")
public class App {

    public static void main(String args[]) {
        System.out.println("Hello world!");
    }
}
