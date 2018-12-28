package com.hly.chapter412.task;

import java.util.concurrent.Callable;

/**
 * code is far away from bug with the animal protecting
 * ┏┓　　　┏┓
 * ┏┛┻━━━┛┻┓
 * ┃　　　　　　　┃
 * ┃　　　━　　　┃
 * ┃　┳┛　┗┳　┃
 * ┃　　　　　　　┃
 * ┃　　　┻　　　┃
 * ┃　　　　　　　┃
 * ┗━┓　　　┏━┛
 * 　　┃　　　┃神兽保佑
 * 　　┃　　　┃代码无BUG！
 * 　　┃　　　┗━━━┓
 * 　　┃　　　　　　　┣┓
 * 　　┃　　　　　　　┏┛
 * 　　┗┓┓┏━┳┓┏┛
 * 　　　┃┫┫　┃┫┫
 * 　　　┗┻┛　┗┻┛
 * ---------------------------------
 *
 * @Author : Hu.Liangyan
 * @Date : Create in 2018/12/17 16:48
 */
public class RealData implements Callable {

    private String data;
    public RealData(String data){
        this.data = data;
    }

    @Override
    public String call() {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < 5; i++){
            sb.append(data);
        }
        return sb.toString();
    }
}
