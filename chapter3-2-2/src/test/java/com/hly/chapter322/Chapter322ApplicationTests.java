package com.hly.chapter322;

import com.hly.chapter322.dao.mapper.ScoreRepository;
import com.hly.chapter322.dao.mapper.UserRepository;
import com.hly.chapter322.entity.Score;
import com.hly.chapter322.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cache.CacheManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class Chapter322ApplicationTests {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CacheManager cacheManager;


    @Autowired
    private ScoreRepository scoreRepository;

    @Test
    public void contextLoads() {
        User user = new User();
        user.setId(5);
        user.setName("xming");

        List<User> list = userRepository.findAll();
        System.out.println("第一次查询：" + list);
        userRepository.save(user);
        list = userRepository.findAll();
        System.out.println("第二次查询：" + list);
    }

    @Test
    public void testCache() {

       User user1 = userRepository.findById(5);
        System.out.println("第一次查询：" + user1.getName());
       /* User user = new User();
        user.setId(5);
        user.setName("hong");*/
       user1.setName("kang");
        userRepository.save(user1);
        User user2 = userRepository.findById(5);
        System.out.println("第二次查询：" + user2.getName());
    }

    @Test
    public void testScore() {
        scoreRepository.save(new Score("hu", "Chinese", 99));
        System.out.println(scoreRepository.findAll());
        System.out.println("== " + scoreRepository.findScoreObj("Chinese"));
    }

}

