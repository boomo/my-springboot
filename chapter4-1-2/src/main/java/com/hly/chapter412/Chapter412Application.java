package com.hly.chapter412;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

@SpringBootApplication
@EnableAsync/*开启异步，让@Async注解能够生效*/
public class Chapter412Application {
    public static void main(String[] args) {
        SpringApplication.run(Chapter412Application.class, args);

    }

}

