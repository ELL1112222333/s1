package org.example.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.example.entity.User;
import org.example.mapper.UserMapper;
import org.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

//还没用到
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
/*
    @Override
    public User get(Integer id) {
        User optionalE = userMapper.selectById(id);
        return optionalE;
    }

    @Override
    public User save(User entityVo) {
        userMapper.insert(entityVo);
        return entityVo;
    }*/

    @Override
    public User loginService(Long phone, String password) {
        //selectone
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("phone",phone).eq("password",password);
        User user=userMapper.selectOne(queryWrapper);
        return user;
    }

    @Override
    public User registService(User newuser) {
        String uuid = UUID.randomUUID().toString();
        newuser.setAuthority(uuid);
        userMapper.insert(newuser);
        return newuser;
    }
}
