package org.example.controller;


import org.example.entity.User;
import org.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.IOException;

/*
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public String login(Long phone, String password, HttpSession session) {
        User login = userService.loginService(phone, password);
        if (login != null) {
            session.setAttribute("user", login);
            System.out.println("登录成功");
            return "redirect:/emp/findAll"; // 跳转到查询所有
        } else {
            return "redirect:/index"; // 跳转回到登录
        }
    }

    @PostMapping("/register")
    public String register(User user, HttpSession session) {
        userService.registService(user); // 注册
        System.out.println("注册成功");
            return "redirect:/index"; // 注册成功跳转到登录界面
    }

}
*/
