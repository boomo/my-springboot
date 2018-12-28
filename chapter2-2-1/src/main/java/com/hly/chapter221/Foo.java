package com.hly.chapter221;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Data
@Component
//@ConfigurationProperties(prefix = "com.hly")
public class Foo {
/*
* @Data  lombok注解 ，省去写get set
* */
    private String foo;
    private String database;

}
