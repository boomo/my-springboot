package com.hly.chapter412;

import com.hly.chapter412.task.AsyncTask;
import com.hly.chapter412.task.RealData;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class Tests {

    @Autowired
    private AsyncTask task;

    @Test
    public void test() throws Exception {
        long b = System.currentTimeMillis();
        Future<String> task1 = task.task1();
        Future<String> task2 = task.task2();
        Future<String> task3 = task.task3();
        while (!(task1.isDone() && task2.isDone() && task3.isDone())){

        }
        log.info(task1.get(5, TimeUnit.SECONDS));
        log.info(task2.get());
        log.info(task3.get());

        long e = System.currentTimeMillis();
        log.info("finished!,用时：{} ms", e - b);
    }

}

