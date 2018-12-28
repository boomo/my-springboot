package com.hly.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class BlogProperties {

    @Value("${com.hly.name}")
    private String name;

    @Value("${com.hly.title}")
    private String title;
    @Value("${com.hly.date}")
    private String date;
    @Value("${com.hly.desc}")
    private String desc;

    @Value("${com.hly.random.value}")
    private String rValue;

    @Value("${com.hly.random.int}")
    private Integer rInt;

    @Value("${com.hly.random.long}")
    private Long rLong;

    @Value("${com.hly.random.test1}")
    private Integer test1;

    @Value("${com.hly.random.test2}")
    private Integer test2;

    @Value("${com.hly.random.test3}")
    private Integer test3;

    @Value("${com.hly.random.uuid}")
    private String uuid;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getrValue() {
        return rValue;
    }

    public void setrValue(String rValue) {
        this.rValue = rValue;
    }

    public Integer getrInt() {
        return rInt;
    }

    public void setrInt(Integer rInt) {
        this.rInt = rInt;
    }

    public Long getrLong() {
        return rLong;
    }

    public void setrLong(Long rLong) {
        this.rLong = rLong;
    }

    public Integer getTest1() {
        return test1;
    }

    public void setTest1(Integer test1) {
        this.test1 = test1;
    }

    public Integer getTest2() {
        return test2;
    }

    public void setTest2(Integer test2) {
        this.test2 = test2;
    }

    public Integer getTest3() {
        return test3;
    }

    public void setTest3(Integer test3) {
        this.test3 = test3;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }
}
