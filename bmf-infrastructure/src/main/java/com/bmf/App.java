package com.bmf;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

/**
 * Hello world!
 *
 */
@SpringBootApplication
@MapperScan("com.bmf.infrastructure.dal.mapper")
public class App {

    public static void main( String[] args ) {
        new SpringApplicationBuilder().sources(App.class)
                .web(WebApplicationType.NONE)
                .run(args);
    }

}
