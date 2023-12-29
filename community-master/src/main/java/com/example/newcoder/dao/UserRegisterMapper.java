package com.example.newcoder.dao;


import com.example.newcoder.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserRegisterMapper {
    User selectById(int id);
}
