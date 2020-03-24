package com.hwua;

import com.hwua.service.MessageService;
import com.hwua.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;


@SpringBootTest
class MessageMybatisPlusApplicationTests {
    @Resource
    private MessageService messageService;
    @Resource
    UserService userService;

    @Test
    void contextLoads() {
    }

}
