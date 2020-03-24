package com.hwua.realm;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.hwua.entity.User;
import com.hwua.service.UserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;


public class UserRealm extends AuthorizingRealm {

    @Autowired
    private UserService userService;
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        System.out.println("权限...");
        return null;
    }

    /**
     * 对当前登录用具进行身份验证
     * 此方法什么时候调用，调用调用subject对象调用login方法的时候，底层调用的是securityManager对象的login方法，此login方法最终调用realm方法中的doGetAuthenticationInfo 方法
     * @param token 此参数就是我们controller传过来的令牌，UsernamePasswordToken对象
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String username=(String)token.getPrincipal();//获取令牌中传过来的用户名
        User user=null;
        try {
            QueryWrapper<User> wrapper = new QueryWrapper<>();
            wrapper.lambda().eq(User::getName,username);
            user = userService.getOne(wrapper);//从数据中找到的用户信息
        } catch (Exception e) {
            e.printStackTrace();
        }
        if(user==null){
            throw  new UnknownAccountException();
        }
        ByteSource salt = ByteSource.Util.bytes(user.getName());//得到salt,salt要不一样
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(user,user.getPwd(),salt,super.getName());
        return authenticationInfo;//把此对象返回给Shiro，shiro会拿这个对象去和你subject传过来的token进行密码比对
    }
}
