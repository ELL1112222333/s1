package com.fd;

import com.fd.entity.User;
import com.fd.mapper.UserMapper;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class MyBatisSpringTest {

    @Test
    public void testSpringMyBatis(){
        /*构建一个Spring容器*/
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("file:D:\\workspace\\s1\\ssmcom\\src\\main\\resources\\spring\\spring-context.xml");

        /*从容器中获取Mapper*/
        UserMapper userMapper = applicationContext.getBean(UserMapper.class);
        User user = userMapper.getUser("1");
        //User user = userMapper.getUser("1");

        System.out.println("用户 = " + user);
    }

}
