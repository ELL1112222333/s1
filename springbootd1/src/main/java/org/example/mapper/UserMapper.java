package org.example.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.example.entity.User;

public interface UserMapper extends BaseMapper<User> {
    @Select("select * from user_information where authority= #{token}")
    User selectToken(@Param("token")String token);
    //@Select("select * from tb_user where id = 1 or id = 2")
    //List<User> getUser();
    //@Select("select * from tb_user where id = #{userId}")
    //User getUser(@Param("userId")Long userid);

    //@Insert("insert into tb_user(id,username,password,gender,addr)values(#{id},#{username},#{password},#{gender},,#{gender})")
    //void save(User user);
}
