package com.hly.chapter327.mapper;

import com.hly.chapter327.entity.Teac;
import com.hly.chapter327.entity.Teacher;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface TeacherMapper {
    void save(Teacher teacher);

    @Select("select tid, tname from teacher")
    List<Teacher> findAll();


    @Results({
            @Result(property = "name", column = "tname")
    })
    @Select("select tname from teacher")
    List<Teac> findNames();
}
