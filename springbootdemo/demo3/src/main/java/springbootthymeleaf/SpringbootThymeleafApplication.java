package springbootthymeleaf;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import springbootthymeleaf.vo.UserVo;

import java.util.ArrayList;

@Controller
@SpringBootApplication
public class SpringbootThymeleafApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringbootThymeleafApplication.class, args);
    }

    @RequestMapping("/")
    public ModelAndView index(){
        ArrayList<UserVo> userVos = new ArrayList<>();
        UserVo userVo = new UserVo();
        userVo.setId(1);
        userVo.setUsername("hqy");
        userVos.add(userVo);
        UserVo userVo2 = new UserVo();
        userVo2.setId(2);
        userVo2.setUsername("hqy2");
        userVos.add(userVo2);

        ModelAndView mv=new ModelAndView();
        mv.addObject("newText","你好，springboot-thymeleaf");
        mv.addObject("gender","1");
        mv.addObject("userList",userVos);
        mv.addObject("loginUser",userVo);
        mv.setViewName("index.html");
        return mv;
    }

}
