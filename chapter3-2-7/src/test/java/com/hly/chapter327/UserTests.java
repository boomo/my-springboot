package com.hly.chapter327;

import com.hly.chapter327.entity.User;
import com.hly.chapter327.mapper.UserMapper;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
//@MybatisTest
//@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class UserTests {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void contextLoads() {
        User user = new User(4, "hu");
        userMapper.save(user);
        user.setName("four");
        userMapper.update(user);

        User u = userMapper.findById(4);
        Assert.assertEquals("four", u.getName());

        userMapper.delete(user);
        u = userMapper.findById(4);
        Assert.assertEquals(null, u);
    }


}

