package com.example.newcoder.service.Imp;


import com.example.newcoder.dao.UserRegisterMapper;
import com.example.newcoder.entity.User;
import com.example.newcoder.service.RegisterService;
import com.example.newcoder.util.CommonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.apache.commons.lang3.StringUtils;
import org.thymeleaf.context.Context;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@Service
public class RegisterServiceImp implements RegisterService {


    @Autowired
    UserRegisterMapper userMapper;
    public Map<String,Object> register(User user){
        Map<String,Object> map = new HashMap<>(10);
        if(user==null){
            throw new IllegalArgumentException("用户信息不能为空");
        }

        // 非空校验
        if(StringUtils.isBlank(user.getUsername())){
            map.put("usernameMsg","账号不能为空!");
            return map;
        }

        if(StringUtils.isBlank(user.getPassword())){
            map.put("passwordMsg","密码不能为空");
            return map;
        }

        if(StringUtils.isBlank(user.getEmail())){
            map.put("emailMsg","邮箱不能为空!");
            return map;
        }

        // 验证用户账号
        User existedUser = userMapper.selectByUserName(user.getUsername());
        if(existedUser!=null){
            map.put("usernameMsg","该账号已存在");
            return map;
        }

        // 验证邮箱
        User mailedUser = userMapper.selectByEmail(user.getEmail());
        if(mailedUser!=null){
            map.put("emailMsg","该邮箱已被注册");
            return map;
        }

        // 注册用户
        // 设置盐值
        user.setSalt(CommonUtil.generateUUID().substring(0,5));
        user.setPassword(CommonUtil.md5Encode(user.getPassword()+user.getSalt()));
        // 用户类型设置为普通用户类型
        user.setType(0);
        // 用户状态设置为未激活状态
        user.setStatus(0);
        // 设置激活码
        user.setActivationCode(CommonUtil.generateUUID());
        // 设置随机头像
        user.setHeaderUrl(String.format("http://images.nowcoder.com/head/%dt.png",new Random().nextInt(1000)));
        user.setCreateTime(new Date());
        userMapper.insertUser(user);

        // 发送激活邮件
        Context context = new Context();
        context.setVariable("email",user.getEmail());
        // 设置邮件激活链接 http://localhost:8080/community/activation/{id}/{activationCode}
//        String url = domain + contextPath + "/user/activation/" + user.getId() + "/" + user.getActivationCode();
//        context.setVariable("url",url);
//        String content = templateEngine.process("/mail/activation", context);
//        mailClientConfig.sendMail(user.getEmail(),"激活账号",content);
        return map;
    }
}
