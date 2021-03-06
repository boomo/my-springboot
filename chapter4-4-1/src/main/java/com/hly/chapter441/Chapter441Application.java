package com.hly.chapter441;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication
public class Chapter441Application {

    public static void main(String[] args) {
        SpringApplication.run(Chapter441Application.class, args);
    }

}

