package com.hly.chapter327;

import com.hly.chapter327.entity.Teac;
import com.hly.chapter327.entity.Teacher;
import com.hly.chapter327.mapper.TeacherMapper;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TeacherTests {

    @Autowired
    private TeacherMapper teacherMapper;

    @Test
    public void contextLoads() {

       /* Teacher teacher = new Teacher(2,"e");
        teacherMapper.save(teacher);*/

        List<Teacher> list = teacherMapper.findAll();
        Assert.assertEquals(3, list.size());

        List<Teac> teacList = teacherMapper.findNames();
        Assert.assertEquals(3, list.size());


        System.out.println(teacList);
    }


}

