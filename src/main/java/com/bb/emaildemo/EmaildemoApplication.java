package com.bb.emaildemo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(value = "com.bb.emaildemo.dao")
public class EmaildemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(EmaildemoApplication.class, args);
    }

}
