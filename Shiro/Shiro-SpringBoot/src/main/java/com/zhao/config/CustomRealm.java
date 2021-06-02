package com.zhao.config;

import com.zhao.pojo.User;
import com.zhao.service.UserService;
import com.zhao.service.UserServiceImpl;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;

public class CustomRealm extends AuthorizingRealm {

    @Autowired
    private UserServiceImpl userService;

    // 授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("授权");

        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        //info.addStringPermission("user-add");

        // 获取 User 对象
        Subject subject = SecurityUtils.getSubject();
        User user = (User) subject.getPrincipal();

        // 从数据库中读取权限，然后授权
        info.addStringPermission(user.getPerms());

        return info;
    }

    // 认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        System.out.println("认证");
        // 前端返回的用户名和密码
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        // 连接数据库判断用户是否存在
        User user = userService.selectUserByName(token.getUsername());
        if (user == null) {
            return null;
        }
        // 密码认证 Shiro 自己做
        return new SimpleAuthenticationInfo(user, user.getPwd(), ""); // 返回 AuthenticationInfo 接口的一个实现类
    }
}
