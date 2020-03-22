package com.hwua.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hwua.dao.UserDao;
import com.hwua.entity.User;
import com.hwua.service.UserService;
import com.hwua.util.MD5Util;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * (User)表服务实现类
 *
 * @author 马涛
 * @since 2020-03-21 21:52:01
 */
@Service("userService")
public class UserServiceImpl extends ServiceImpl<UserDao, User> implements UserService {

    @Resource
    UserDao userDao;

    @Override
    public boolean save(User user) {
        user.setPwd(MD5Util.md5hash(user.getName(), user.getPwd()));
        return this.userDao.insert(user) > 0;
    }

    @Override
    public String login(User user) {
        String info=null;
        Subject currentUser = SecurityUtils.getSubject();//创建一个用户（主题）
        //判断当前用户是否登录成功
        if(!currentUser.isAuthenticated()){
            //把用户名和密码封装在UsernamePasswordToken中
            UsernamePasswordToken token = new UsernamePasswordToken(user.getName(), user.getPwd());
            try {
                //进行登录验证
                currentUser.login(token);
                //底层交给securityManager对象去调用注册得realm从文件或数据库中找到此登录用户的用户名和密码信息，拿到这些信息以后
                //和token中的用户名、密码进行比对。
            } catch (UnknownAccountException uae) {
                info="不存在此用户";
            } catch (IncorrectCredentialsException ice) {
                info="密码不正确";
            } catch (LockedAccountException lae) {
                info="账号锁定";
            } catch (AuthenticationException ae) {
                info="联系管理员";
            }
        }
        return info;
    }

    @Override
    public User findByName(String name) {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.lambda().eq(User::getName,name);
        return userDao.selectOne(wrapper);
    }
}