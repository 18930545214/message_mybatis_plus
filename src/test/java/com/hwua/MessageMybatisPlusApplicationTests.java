package com.hwua;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.hwua.entity.Message;
import com.hwua.entity.User;
import com.hwua.service.MessageService;
import com.hwua.service.UserService;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.function.Try;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

import static org.junit.platform.commons.function.Try.success;

@SpringBootTest
class MessageMybatisPlusApplicationTests {
    @Resource
    private MessageService messageService;
    @Resource
    UserService userService;

    @Test
    void contextLoads() {
        User user = new User();
        user.setEmail("123@qq.com");
        List<User> list = this.userService.list();
        System.out.println(list);
    }

}
