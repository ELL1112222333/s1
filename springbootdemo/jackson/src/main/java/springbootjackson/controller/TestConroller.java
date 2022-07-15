package springbootjackson.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import springbootjackson.vo.UserVoByJson;
import springbootjackson.vo.UserVoByMvc;

import java.util.List;


//使用@RestController标注类，相对于所有的方法都用@ResponseBody标注，
//MVC会帮我们调用序列化，将Java对象转成Json再响应给调用方，
//同时形参要加@RequestBody标注，MVC会帮我们调用反序列化将Json转成Java对象，
//这就要求我们调用的时候需要传一个Json字符串过来

@RestController
@RequestMapping("/")
public class TestConroller {
    /**
     * 跳转页面，页面引入了jquery，主要用于下面的ajax调用测试
     */
    @GetMapping("/")
    public ModelAndView index(){
        return new ModelAndView("index");
    }
 /*
        $.ajax({
           type:"POST",
           url:"http://localhost:10099/testByJson",
           data:JSON.stringify({
                userName:"sa",
                pass_word:"123fff",
                captcha:"abcd",
                createDate:"2019-08-05 11:34:31"
            }),
           dataType:"JSON",
           contentType:"application/json;charset=UTF-8",
           success:function(data){
               console.log(data);
           },
           error:function(data){
                console.log("报错啦");
           }
        })
     */
    /**
     * 反序列化方式注入，只能post请求
     */
    @PostMapping("testByJson")
    public UserVoByJson testByJson(@RequestBody UserVoByJson userVo) {
        System.out.println(userVo);
        return userVo;
    }
/*
        $.ajax({
           type:"POST",
           url:"http://localhost:10099/testByMvc",
           data:{
                username:"sa",
                password:"123fff",
                captcha:"abcd"
            },
           dataType:"JSON",
           //contentType:"application/json;charset=UTF-8",//使用这个，get请求能接到参数，post接不到
           contentType:"application/x-www-form-urlencoded",//使用这个，get、post都能接收到参数
           success:function(data){
               console.log(data);
           },
           error:function(data){
                console.log("报错啦");
           }
        })
     */
    /**
     * MVC方式注入
     */
    @RequestMapping("testByMvc")
    public UserVoByMvc testByMvc(UserVoByMvc userVo) {
        System.out.println(userVo);
        return userVo;
    }



}
