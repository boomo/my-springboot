package com.hly.chapter327.controller;

import com.hly.chapter327.entity.Teacher;
import com.hly.chapter327.mapper.TeacherMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/teacher")
public class TeacherController {

    @Autowired
    private TeacherMapper teacherMapper;

    @GetMapping("/add")
    public Teacher save(){
        Teacher teacher = new Teacher(1,"e");
        teacherMapper.save(teacher);
        return teacher;
    }

    @GetMapping("/hi")
    public String hi(){
        return  "hi";
    }
}
