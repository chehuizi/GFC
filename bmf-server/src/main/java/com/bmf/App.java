package com.bmf;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Hello world!
 *
 */
@SpringBootApplication
@MapperScan("com.bmf.infrastructure.dal.mapper")
public class App {

    public static void main( String[] args ) {
        SpringApplication.run(App.class, args);
    }

}
