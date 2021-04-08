package com.ahao.java.music;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*
*
*热更新热加载 crtl+shift+alc+/ 开启*/
@SpringBootApplication
@MapperScan("com.ahao.java.music.dao")
public class MusicApplication {

    public static void main(String[] args) {

        SpringApplication.run(MusicApplication.class, args);
    }

}
