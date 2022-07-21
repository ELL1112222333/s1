package org.example.controller;

import lombok.extern.slf4j.Slf4j;
import org.example.aopannotation.Action;
import org.example.entity.User;
import org.example.service.UserService;
import org.example.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

//@Slf4j
@RestController
@RequestMapping("/open")
public class IndexController {
   /* @Autowired
    private UserService userService;

    @GetMapping("/get/{id}")
    @ResponseBody
    public User get(@PathVariable("id")Integer id) {
        return userService.get(id);
    }

    @GetMapping("/save")
    @ResponseBody
    public User save(@Validated User entityVo) {
        log.info("用户插入!");
        return userService.save(entityVo);
    }*/

    @Autowired
    private UserService userService;

    @Action(aopname = "登录操作")
    @PostMapping("/login")
    public Result<User> loginController(@RequestParam Long phone, @RequestParam String password){
        User user = userService.loginService(phone, password);
        if(user!=null){
            return Result.success(user,"登录成功！");
        }else{
            return Result.error("123","账号或密码错误！");
        }
    }


    @Action(aopname = "注册操作")
    @PostMapping("/register")
    //@GetMapping("/register")
    public Result<User> registController(@RequestBody User newUser){
        User user = userService.registService(newUser);
        if(user!=null){
            return Result.success(user,"注册成功！");
        }else{
            return Result.error("456","用户名已存在！");
        }
    }



}
