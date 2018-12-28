package com.hly.chapter426;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
@Slf4j
public class Chapter426Application {

    public static void main(String[] args) {
        SpringApplication.run(Chapter426Application.class, args);
    }


    @RequestMapping("/index")
    public String index(){
        log.info("输出info");
        log.debug("输出debug");
        log.error("输出error");
        return "ok";

    }
}

