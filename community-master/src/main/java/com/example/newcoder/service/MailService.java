package com.example.newcoder.service;

public interface MailService {

    /**
     * 简单文本邮件
     * @param toUser 邮件接收者
     */
    public void sendHtmlMail(String to,String subject,String content)throws Exception;

}