package com.hly.chapter312.controller;


import com.hly.chapter312.exception.Exception1;
import com.hly.chapter312.exception.Exception2;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExceptionTestController {

    @RequestMapping("/err")
    public String err() throws Exception {
        throw new Exception("异常信息");
    }

    @RequestMapping("/err1")
    public String err1() throws Exception1 {
        throw new Exception1("异常信息1");
    }

    @RequestMapping("/err2")
    public String err2() throws Exception2 {
        throw new Exception2("异常信息2");
    }

}
