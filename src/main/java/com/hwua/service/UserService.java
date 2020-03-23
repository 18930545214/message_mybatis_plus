package com.hwua.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hwua.entity.User;

/**
 * (User)表服务接口
 *
 * @author 马涛
 * @since 2020-03-21 21:52:01
 */
public interface UserService extends IService<User> {

    /**
     * 用户登录功能
     * @param user 实体对象
     * @return 错误信息
     */
    String login(User user);
}