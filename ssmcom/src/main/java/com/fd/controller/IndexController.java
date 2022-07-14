package com.fd.controller;

import com.fd.entity.User;
import com.fd.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.PostConstruct;

@Controller
public class IndexController {


    @PostConstruct
    public void init(){
        System.out.println("init...");
    }



    @RequestMapping("/hello")
    @ResponseBody
    public String test() throws Exception{
        return "Hello F2135";
    }

    @RequestMapping("/urlencoded")
    @ResponseBody
    public String test2(@RequestParam Long id) throws Exception{
        return "Hello 2";
    }

    @Autowired
    private UserService userService;


    @RequestMapping("/user")
    @ResponseBody
    public String getUser(@RequestBody Long id) throws Exception{
        final User user = userService.getUser(id);

        return "中文"+user.toString();
    }


}
