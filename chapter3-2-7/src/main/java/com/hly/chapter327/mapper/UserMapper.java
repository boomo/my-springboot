package com.hly.chapter327.mapper;

import com.hly.chapter327.entity.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface UserMapper {
    @Insert("insert into user(id, name) values(#{id}, #{name})")
    void save(User user);

    @Update("update user set name=#{name} where id=#{id}")
    void update(User user);

    @Select("select id,name from user where id=#{id}")
   User findById(Integer id);

    @Delete("delete from user where id=#{id}")
    void delete(User user);


    @Insert("insert into user(id, name) values (#{id},#{name})")
    void insert(@Param("id") Integer id, @Param("name") String name);

    @Select("select * from user")
    List<User> findAll();

    @Select("select * from user where name=#{name}")
    List<User> selectByName(String name);
}
