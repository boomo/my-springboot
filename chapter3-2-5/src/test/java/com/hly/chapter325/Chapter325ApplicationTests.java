package com.hly.chapter325;

import com.hly.chapter325.domain.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Chapter325ApplicationTests {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    public void contextLoads() {
        stringRedisTemplate.opsForValue().set("magic:cube:platform","001");
        System.out.println(stringRedisTemplate.opsForValue().get("magic:cube:platform"));
        Assert.assertEquals("001", stringRedisTemplate.opsForValue().get("magic:cube:platform"));

        User user = new User("超人", 20);
        redisTemplate.opsForValue().set("蜘蛛侠", user);
        System.out.println(redisTemplate.opsForValue().get("蜘蛛侠"));
    }

}

