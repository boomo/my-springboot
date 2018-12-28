package com.hly.chapter312.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {

    @RequestMapping("/")
    public String index(ModelMap map){
        map.put("host", "www.baidu.com");
        return "index";
    }

    @RequestMapping("/index2")
    public ModelAndView index2(ModelAndView view){
        view.addObject("host", "www.baidu2.com");
        view.setViewName("index");
        return view;
    }

    @ResponseBody
    @RequestMapping("/index1")
    public String index1(){
        return "index";
    }

    @ResponseBody
    @RequestMapping("/hi")
    public String hi(){
        return "hi";
    }


}
