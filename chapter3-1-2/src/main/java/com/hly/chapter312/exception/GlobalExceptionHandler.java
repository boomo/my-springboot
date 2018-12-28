package com.hly.chapter312.exception;

import com.hly.chapter312.dto.ErrorInfo;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ResponseBody
    @ExceptionHandler(value = Exception.class)
    public ErrorInfo<String> err(Exception e, HttpServletRequest req){
        ErrorInfo<String> r = new ErrorInfo<>();
        r.setUrl(req.getRequestURI());
        r.setCode(ErrorInfo.ERROR);
        r.setMessage(e.getMessage());
        r.setData("发生异常：" + e.getMessage());
        return r;
    }


    @ExceptionHandler(value = Exception1.class)
    public ModelAndView err1(HttpServletRequest req, Exception e){
        ModelAndView map = new ModelAndView();
        map.addObject("url", req.getRequestURL());
        map.addObject("exception", e);
        map.setViewName("error1");
        return map;
    }

/*
* 使用ModelMap 不可行
* */
@ResponseBody
    @ExceptionHandler(value = Exception2.class)
    public ModelMap err2(HttpServletRequest req, Exception e){
        ModelMap map = new ModelMap();
        map.put("url", req.getRequestURL());
        map.put("exception", e);
        return map;
    }



}
