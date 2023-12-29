package com.example.newcoder.entity;

import lombok.Data;

import java.util.Date;

@Data
public class LoginTicket {

    private int id;
    private int userId;
    private String ticket;//凭证字符串
    private int status;//状态0有效1无效
    private Date expired;//到期日期

    @Override
    public String toString() {
        return "LoginTicket{" +
                "id=" + id +
                ", userId=" + userId +
                ", ticket='" + ticket + '\'' +
                ", status=" + status +
                ", expired=" + expired +
                '}';
    }
}

