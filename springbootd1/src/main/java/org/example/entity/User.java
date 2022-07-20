package org.example.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

//import javax.validation.constraints.NotEmpty;
/*
@Data
@TableName("tb_user")
public class User {

    private Integer id         ;
    private String username   ;
    private String password   ;

  //  @NotEmpty(message = "性别不能为空")
    private String gender     ;

 //   @NotEmpty(message = "地址不能为空")
    private String addr       ;


}*/
@Data
@TableName("user_information")
public class User {

    private Long id;
    private String username;
    private String password;
    private Long phone;
    private Integer status;
    private String authority;
}