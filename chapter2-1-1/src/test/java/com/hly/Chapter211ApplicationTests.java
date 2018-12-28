package com.hly;

import com.hly.service.BlogProperties;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Chapter211ApplicationTests {

    Logger logger = LoggerFactory.getLogger(Chapter211ApplicationTests.class);
    private static final Log log = LogFactory.getLog(Chapter211ApplicationTests.class);

    @Autowired
    private BlogProperties blog;

    @Test
    public void contextLoads() {
        Assert.assertEquals("hly", blog.getName());
        Assert.assertEquals("SpringBoot-Learning", blog.getTitle());
        Assert.assertEquals("2018-12-10", blog.getDate());
        Assert.assertEquals("hly在2018-12-10学习《SpringBoot-Learning》", blog.getDesc());


        log.info("随机字符串 ： " + blog.getrValue());
        log.info("随机int ： +" + blog.getrInt());
        log.info("随机long ： "+ blog.getrLong());
        log.info("10以内int ： " + blog.getTest1());
        log.info("(1,3) : " + blog.getTest2());
        log.info("[1,3] : " + blog.getTest3());
        log.info("uuid : " + blog.getUuid());

        logger.info("uuid: {}",blog.getUuid());
    }

}
