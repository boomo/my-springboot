package com.hly.chapter412.task;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Random;
import java.util.concurrent.Future;

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
 * @Date : Create in 2018/12/18 10:47
 */

@Slf4j
@Component
public class AsyncTask {

    private static Random random = new Random();

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Async("taskExecutor")
    public Future<String> task1() throws InterruptedException {
        log.info("task1 begin...");
        long b = System.currentTimeMillis();
        Thread.sleep(random.nextInt(10000));
        /*从当前数据库中随机返回一个 key*/
        try{log.info(stringRedisTemplate.randomKey());}catch (Exception e){
            e.printStackTrace();
        }

        long e = System.currentTimeMillis();
//        log.info("task1 end,spend: " + (e - b) + " ms");
        log.info("task1 end, spend: {} ms" , e - b);
        return new AsyncResult<>("task1 done!");
    }

    @Async("taskExecutor")
    public Future<String> task2() throws InterruptedException {
        log.info("task2 begin...");
        long b = System.currentTimeMillis();
        Thread.sleep(random.nextInt(10000));
        log.info(stringRedisTemplate.randomKey());
        long e = System.currentTimeMillis();
        log.info("task2 end,spend: " + (e - b) + " ms");
        return new AsyncResult<>("task2 done!");
    }

    @Async("taskExecutor")
    public Future<String> task3() throws InterruptedException {
        log.info("task3 begin...");
        long b = System.currentTimeMillis();
        Thread.sleep(random.nextInt(10000));
        log.info(stringRedisTemplate.randomKey());
        long e = System.currentTimeMillis();
        log.info("task3 end,spend: " + (e - b) + " ms");
        return new AsyncResult<>("task3 done!");
    }
}
