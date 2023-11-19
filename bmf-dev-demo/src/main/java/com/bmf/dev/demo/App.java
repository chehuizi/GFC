package com.bmf.dev.demo;

import com.bmf.dev.annotations.Domain;
import com.bmf.dev.client.registrar.EnableBMFScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * 启动类
 */
@SpringBootApplication
@ComponentScan(basePackages = {"com.bmf.dev.demo"})
@EnableBMFScan(basePackages = {"com.bmf.dev.demo"})
@Domain(domainCode = 101, domainAlias = "wms", appId = 5001, appName = "app_wms", appDesc = "wms应用")
public class App {

    public static void main(String args[]) {
        SpringApplication.run(App.class, args);
    }
}
