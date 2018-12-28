package com.hly.chapter327;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.hly.chapter327.mapper")
public class Chapter327Application {

    public static void main(String[] args) {
        SpringApplication.run(Chapter327Application.class, args);
    }

}

