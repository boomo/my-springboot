package com.hly.chapter441;

import com.hly.chapter441.entity.User;
import com.hly.chapter441.repository.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cache.CacheManager;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Chapter441ApplicationTests {

    @Autowired
    private CacheManager cacheManager;

    @Autowired
    private UserRepository repository;

    @Test
    public void contextLoads() {

        System.out.println("第一次 : " + repository.findAll());
        User user = new User();
        user.setId(5);
        user.setName("xiaoming");
        repository.save(user);
        System.out.println("第二次 : " + repository.findAll());
    }

    @Test
    public void test() {

        User user1 = repository.findById(1);
        System.out.println("第一次查询：" + user1.getName());
        System.out.println("-------------------");
        User user = new User();
        user.setId(1);
        user.setName("aq");
        repository.save(user);
        System.out.println("-------------------");
        User user2 = repository.findById(1);
        System.out.println("第二次查询：" + user2.getName());
    }

}

