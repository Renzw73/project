package com.example.newcoder.TestRegister;


import com.example.newcoder.dao.UserRegisterMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class T_register {


    @Autowired
    UserRegisterMapper registerMapper;

    @Test// 测试插入用户
    public void testInsert()
    {

    }

}
