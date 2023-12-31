package com.example.newcoder.dao;

import com.example.newcoder.entity.LoginTicket;
import com.example.newcoder.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface LoginTicketMapper {

//   插入输出，影响行数
    int insertLoginTicket(LoginTicket loginTicket);

//    查询，依据ticket，ticket是凭证，发送给cookie浏览器存，其他的在服务器存，下次cookie给服务器，服务器查到其他的数据，ticket唯一标识
    LoginTicket selectByTicket(String ticket);

//    退出，状态改变
    int updateStatus(String ticket, int status);

    User selectByUserName(String username);

}
