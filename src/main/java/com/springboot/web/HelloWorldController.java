package com.springboot.web;

import com.springboot.comm.VersionProperties;
import com.springboot.domain.User;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
public class HelloWorldController {

    @Resource
    private VersionProperties properties;

    @RequestMapping(value = "/hello", method = RequestMethod.POST)
    public String hello(String name) {
        return "hello world：" + name;
    }

    @RequestMapping(value = "/getUser")
    public User getUser() {
        User user = new User();
        user.setAge(20);
        user.setName("Neo");
        user.setPhone("0512-6668 8888");
        return user;
    }

    @RequestMapping(value = "getUsers")
    public List<User> getUsers() {
        List<User> users = new ArrayList<>();
        User user1 = new User();
        user1.setName("neo");
        user1.setAge(30);
        user1.setPhone("neo123");
        users.add(user1);
        User user2 = new User();
        user2.setName("小明");
        user2.setAge(12);
        user2.setPhone("123456");
        users.add(user2);
        return users;
    }

    @RequestMapping(value = "get/{name}", method = RequestMethod.GET)
    public User get(@PathVariable String name) {
        User user = new User();
        user.setName(name);
        return user;
    }

    @RequestMapping(value = "save", method = RequestMethod.POST)
    public User save(@Valid User user, BindingResult result) {
        System.out.println("user:" + user);
        if (result.hasErrors()) {
            List<ObjectError> list = result.getAllErrors();
            for (ObjectError error : list) {
                System.out.println(error.getCode() + ":" + error.getDefaultMessage());
            }
        }
        return user;
    }

    @RequestMapping(value = "/getProperties", method = RequestMethod.GET)
    public String getProperties(){
        return properties.toString();
    }
}
