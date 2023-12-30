package com.example.newcoder.controller;


import com.example.newcoder.entity.User;
import com.example.newcoder.service.Imp.RegisterServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;

@Controller
public class RegisterController {


    @Autowired
    RegisterServiceImp registerService;
    @RequestMapping(path = "/user/registerPage",method = RequestMethod.GET)
    public String registerPage(){
        return "site/register";
    }

    @RequestMapping(path = "/user/register", method = RequestMethod.POST)
    public String register(Model model, User user){
        Map<String,Object> map = registerService.register(user);
        if(map == null || map.isEmpty()){
            model.addAttribute("msg","注册成功，我们已经向您的邮箱发送了一封激活邮件，请尽快激活！");
            model.addAttribute("target","/index");
            return "site/operate-result";
        }else{
            model.addAttribute("usernameMsg",map.get("usernameMsg"));
            model.addAttribute("passwordMsg",map.get("passwordMsg"));
            model.addAttribute("emailMsg",map.get("emailMsg"));
            return "site/register";
        }
    }
}
