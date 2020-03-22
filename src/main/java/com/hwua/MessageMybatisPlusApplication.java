package com.hwua;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.hwua.dao")
public class MessageMybatisPlusApplication {

    public static void main(String[] args) {
        SpringApplication.run(MessageMybatisPlusApplication.class, args);
    }

}
