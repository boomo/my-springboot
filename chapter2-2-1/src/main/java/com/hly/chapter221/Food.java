package com.hly.chapter221;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@ConfigurationProperties
public class Food {

    private String name;
    private String taste;
}
