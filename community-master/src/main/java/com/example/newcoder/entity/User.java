package com.example.newcoder.entity;


/*
* 1. 仿照牛客网用户实体类
* 2.
* */
import lombok.Data;
import org.springframework.context.annotation.Bean;

import java.util.Date;

@Data
public class User {
    private int id;  // 网站生成的用户ID
    private String username; // 注册时用户自定义的用户名
    private String password;  // 注册时用户自定义的密码
    private String salt;
    private String email; //  注册时用户自定义的用户名
    private int type;  // 0 表示普通用户 1 表示VIP用户 2 表示 管理员
    private int status; //
    private String activationCode; // 激活码
    private String headerUrl; // 用户的头像链接
    /**
     * 用户注册时间
     */
    private Date createTime;  // 用户的注册时间
}
