package com.ahao.java.music.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.Random;
import java.util.concurrent.TimeUnit;

@Service
public class MailService {
    @Autowired
    private JavaMailSender javaMailSender;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Value("${spring.mail.username}")
    private String from;

    public boolean sendMail(String email){
        try {
            SimpleMailMessage mailMessage=new SimpleMailMessage();
            mailMessage.setSubject("验证码邮件");
            String code=randomCode();
            mailMessage.setText("您的验证码是:"+code+"，有效期三分钟");
            mailMessage.setTo(email);
            mailMessage.setFrom(from);
            javaMailSender.send(mailMessage);
            stringRedisTemplate.opsForValue().set(email,code,5,TimeUnit.MINUTES);
            return true;
        } catch (MailException e) {
            e.printStackTrace();
            return false;
        }
    }

    private String randomCode(){
        StringBuilder str = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < 6; i++) {
            str.append(random.nextInt(10));
        }
        return str.toString();
    }

    public boolean verifyCode(String email,String code){
        String redisCode=stringRedisTemplate.opsForValue().get(email);
        if (redisCode==null){
            return false;
        }
        if (redisCode.equals(code)){
            return true;
        }
        return false;
    }
}
