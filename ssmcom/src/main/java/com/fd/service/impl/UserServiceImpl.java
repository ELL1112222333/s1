package com.fd.service.impl;

import com.fd.entity.User;
import com.fd.mapper.UserMapper;
import com.fd.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public User getUser(String id) {
        final User user = userMapper.getUser(id);
        //System.out.println(user.toString());
        return user;
    }
}
