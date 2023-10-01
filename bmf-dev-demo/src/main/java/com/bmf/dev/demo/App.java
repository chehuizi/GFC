package com.bmf.dev.demo;

import com.bmf.dev.client.registrar.EnableBMFScan;
import com.bmf.dev.annotations.Domain;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * 启动类
 */
@SpringBootApplication
@ComponentScan(basePackages = {"com.bmf.demo"})
@EnableBMFScan(basePackages = {"com.bmf.demo.api"})
@Domain(appId = 5001, appName = "app_wms", appDesc = "wms应用",
        domainCode = 101, domainAlias = "wms")
public class App {

    public static void main(String args[]) {
        SpringApplication.run(App.class, args);
    }
}
