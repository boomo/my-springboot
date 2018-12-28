package com.hly.chapter412;

import com.hly.chapter412.task.RealData;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Chapter412ApplicationTests {

    @Test
    public void test() {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(
                5, 5, 0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<>(5),
                new ThreadFactory() {
                    @Override
                    public Thread newThread(Runnable r) {
                        Thread thread = new Thread(r);
                        thread.setName("MyThread");
                        return thread;
                    }
                }
        );

        Future<String> future = executor.submit(new RealData("hhh"));

        FutureTask<String> futureTask = new FutureTask<>(new RealData("hhh"));
        executor.execute(futureTask);


    }

}

