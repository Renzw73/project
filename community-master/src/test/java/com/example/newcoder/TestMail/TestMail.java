package com.example.newcoder.TestMail;

import com.example.newcoder.service.Imp.MailServiceImp;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;


@SpringBootTest
public class TestMail {

    @Autowired
    private MailServiceImp mailClient;

    @Autowired
    private TemplateEngine templateEngine;

    //直接发送文字信息
    @Test
    public void testTextMail() {

    }

    //发送动态网页
    @Test
    public void testHtmlMail() throws Exception {
        Context context = new Context();
        context.setVariable("username", "rzw");  //将变量内容填充到模板中

        String content = templateEngine.process("/mail/test_mail", context);
        System.out.println(content);

        mailClient.sendHtmlMail("1293817436@qq.com", "HTML", content);
    }

}


