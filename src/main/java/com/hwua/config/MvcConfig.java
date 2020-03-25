package com.hwua.config;

import com.baomidou.mybatisplus.extension.api.R;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig {
    //创建一个实现WebMvcConfigurer接口的对象放到容器中
    @Bean
    public WebMvcConfigurer extWebMvcConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addViewControllers(ViewControllerRegistry registry) {
                //注册映射路径到指定的视图
                registry.addViewController("/pages/main.html").setViewName("pages/main");
                registry.addViewController("/pages/menu.html").setViewName("pages/menu");
                registry.addViewController("/pages/readMsg.html").setViewName("pages/readMsg");
                registry.addViewController("/pages/newMsg.html").setViewName("pages/newMsg");
                registry.addViewController("/index.html").setViewName("index");
                registry.addViewController("/error.html").setViewName("error");
                registry.addViewController("/register.html").setViewName("register");
            }
        };
    }
}
