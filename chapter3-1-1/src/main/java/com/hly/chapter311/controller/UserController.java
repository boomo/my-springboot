package com.hly.chapter311.controller;


import com.hly.chapter311.domain.User;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

@RestController
@RequestMapping("/users")
public class UserController {
    /**
     * get  /users/   所有用户列表
     * post  /users/     添加一个用户
     * get  /users/id   根据id查询用户
     * put  /users/id   根据id更新用户
     * delete /users/id     根据id删除用户
     */

    static Map<String, User> userMap = Collections.synchronizedMap(new HashMap<String, User>());

    @GetMapping("/")
    public List<User> listUser(){
        List<User> list = new ArrayList<>(userMap.values());
        return list;
    }

    @PostMapping("/testP")
    public User testUser(@RequestBody User user){
        System.out.println("====================/testP");
        System.out.println(user);
        return user;
    }

    @GetMapping("/testG")
    public String testUserG(String user, String p, HttpServletRequest request){
        System.out.println("====================/testG");

        System.out.println(user);
        System.out.println(p);
        return p;
    }

    @PostMapping("/")
    public String postUser(@ModelAttribute User user){
        userMap.put(user.getId(), user);
        return "success";
    }

    @GetMapping("/{id}")
    public User getUser(@PathVariable("id") String id){
        User user = userMap.get(id);
        return user;
    }

    @PutMapping(value = "/{id}")
    public User putUser(@PathVariable String id, @ModelAttribute User user){
        User user1 = userMap.get(id);
        user1.setName(user.getName());
        user1.setAge(user.getAge());
        return user1;
    }

    @DeleteMapping("/{id}")
    public String delUser(@PathVariable String id){
        User user = userMap.remove(id);
        return "success";
    }

    @GetMapping(value = "/getName")
    public String getName(@RequestParam("id") String id){
        return userMap.get(id).getName();
    }

}
