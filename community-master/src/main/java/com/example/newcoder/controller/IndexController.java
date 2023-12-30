package com.example.newcoder.controller;


import com.example.newcoder.vo.PageInfo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


/*
* 1. 首页访问控制器
* */
@Controller
public class IndexController {
    @RequestMapping(path = {"/index","/"},method = RequestMethod.GET)
    public String getIndexPage(Model model, PageInfo pageInfo, @RequestParam(name = "orderMode",defaultValue = "0") int orderMode){
        return "/index";
    }

}
