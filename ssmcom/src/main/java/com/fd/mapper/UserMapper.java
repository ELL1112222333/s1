package com.fd.mapper;


import com.fd.entity.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserMapper {
    //@Select("select * from tb_user where id = 1 or id = 2")
    //List<User> getUser();
    @Select("select * from tb_user where id = #{userId}")
    User getUser(@Param("userId")String userid);
}
