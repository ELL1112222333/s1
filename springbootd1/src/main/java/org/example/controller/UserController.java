package org.example.controller;


import lombok.extern.slf4j.Slf4j;
import org.example.aopannotation.Action;
import org.example.aopannotation.Autho;
import org.example.aopannotation.IPLimit;
import org.example.entity.User;
import org.example.service.UserService;
import org.example.utils.Result;
import org.example.utils.ThreadLocalCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.IOException;

@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;


    @IPLimit(limitNum=1)
    @Action(aopname = "查看信息")
    @PostMapping("/get")
    public Result<User> checkController(){
        User user = ThreadLocalCache.get();
        return Result.success(user,"查看信息");
    }

    @PostMapping("/get2")
    public void check2Controller(){
        log.info("已得到用户");
        //return Result.success(user,"查看信息");
    }


    @Autho(aopname = "user:select")
    @Action(aopname = "修改姓名")
    @PostMapping("/modifyName")
    public Result<User> modifyNameController(@RequestParam String newName){
        User user = ThreadLocalCache.get();
        User modifyuser=userService.modifyName(user,newName);
        return Result.success(user,"修改成功！");
    }

}

