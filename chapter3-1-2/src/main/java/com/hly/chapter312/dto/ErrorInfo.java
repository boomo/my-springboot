package com.hly.chapter312.dto;


import lombok.Data;

@Data
public class ErrorInfo<T> {
    public static final Integer OK = 0;
    public static final Integer ERROR = 100;
    private String url;
    private String message;
    private Integer code;
    private T data;
}
