package com.hly.chapter451;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.test.context.junit4.SpringRunner;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;
import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Chapter451ApplicationTests {

    @Autowired
    private JavaMailSender mailSender;

    @Test
    public void contextLoads() {

        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("huliangyan@hancloud.cn");
        message.setTo("huliangyan@hancloud.cn");
        message.setSubject("message");
        message.setText(new Date().toString());
        mailSender.send(message);
    }


    @Test
    public void test1(){
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("huliangyan@hancloud.cn");
        message.setTo("914255966@qq.com");
        message.setSubject("msg");
        Date date = new Date();
        String msg = date.toString();
        System.out.println(msg);
        message.setText(msg);
        mailSender.send(message);
    }


    @Test
    public void test2() throws MessagingException {
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage);
        helper.setFrom("huliangyan@hancloud.cn");
        helper.setTo("914255966@qq.com");
        helper.setSubject("msg");
        Date date = new Date();
        String msg = date.toString();
        System.out.println(msg);
        helper.setText(msg);
//C:\Users\XL\Desktop
        FileSystemResource file = new FileSystemResource(new File("C://Users//XL//Desktop"));

        helper.addAttachment("附件1", file);
        helper.addAttachment("附件2", file);
        mailSender.send(mimeMessage);

    }

}

