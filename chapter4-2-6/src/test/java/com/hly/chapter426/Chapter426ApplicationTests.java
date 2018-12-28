package com.hly.chapter426;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Chapter426ApplicationTests {

    private Logger logger = LoggerFactory.getLogger(Chapter426ApplicationTests.class);

    @Test
    public void contextLoads() {
        logger.info("输出info");
        logger.debug("输出debug");
        logger.error("输出error");
    }

}

