package com.hly.web;


import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @PostMapping(value = "/user" ,consumes = MediaType.APPLICATION_XML_VALUE , produces = MediaType.APPLICATION_XML_VALUE)
    public User addUser(@RequestBody User user){
        user.setName("**" + user.getName());
        user.setAge(user.getAge() + 10);
        return user;
    }

    @PostMapping(value = "/addUser")
    public User add(@ModelAttribute User user){
        user.setName("**" + user.getName());
        user.setAge(user.getAge() + 10);
        return user;
    }

    @PostMapping(value = "/add")
    public User addu(@RequestBody User user){
        user.setName("**" + user.getName());
        user.setAge(user.getAge() + 10);
        System.out.println(user);
        return user;
    }

    @PostMapping(value = "/add2")
    public User add2(User user){
        user.setName("**" + user.getName());
        user.setAge(user.getAge() + 10);
        System.out.println(user);
        return user;
    }
}
