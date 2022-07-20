package org.example.service;

import org.example.aopannotation.Action;
import org.example.entity.User;

public interface UserService {
    //public User getUser(Long id);
    //List<User> list(User entityVo);

    /*User get(Integer id);

    User save(User entityVo);*/

    //Integer delete(Integer id);

    User loginService(Long phone, String password);


    User registService(User user);

    User selectToken(String token);
}