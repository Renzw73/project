package com.example.newcoder.controller;

import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.example.newcoder.service.Imp.LoginServiceImp;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class LoginController {

    /**
     * 默认状态的登录凭证的超时时间
     */
    int DEFAULT_EXPIRED_SECONDS = 3600 * 12;

    /**
     * 记住状态的登录凭证超时时间
     */
    int REMEMBER_EXPIRED_SECONDS = 3600 * 24 * 100;


    private String contextPath;


    private LoginServiceImp loginServiceImp;


    @RequestMapping(path = "/user/loginPage",method = RequestMethod.GET)
    public String loginPage(){
        return "/site/login";
    }

    @RequestMapping(path = "login", method = RequestMethod.POST)
    public String login(HttpServletRequest request, Model model, HttpSession session,HttpServletResponse response) {

//        获取参数
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String code = request.getParameter("code");
        String strememberme = request.getParameter("rememberme");
        boolean remenberme = Boolean.getBoolean(strememberme);

//        检查验证码，为空或者不匹配，返回登录页面
        String kaptcha = (String) session.getAttribute("kaptcha");

        if (StringUtils.isBlank(kaptcha) || StringUtils.isBlank(code) || !kaptcha.equalsIgnoreCase(code)) {
            model.addAttribute("codeMsg", "验证码不正确!");
            return "/site/login";
        }


        int expiredSeconds = remenberme ? REMEMBER_EXPIRED_SECONDS : DEFAULT_EXPIRED_SECONDS;
        Map<String, Object> map = loginServiceImp.login(username, password, expiredSeconds);


        return "site/login";

    }


//    退出功能
    @RequestMapping(path = "/logout", method = RequestMethod.GET)
    public String logout(@CookieValue("ticket") String ticket) {
        loginServiceImp.logout(ticket);
        return "redirect:/login";
    }

}
