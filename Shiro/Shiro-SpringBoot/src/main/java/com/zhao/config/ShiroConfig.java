package com.zhao.config;


import at.pollux.thymeleaf.shiro.dialect.ShiroDialect;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class ShiroConfig {

    // ShiroFilterFactoryBean
    @Bean
    public ShiroFilterFactoryBean shiroFilterFactoryBean(@Qualifier("getSecurityManager") DefaultWebSecurityManager securityManager) {
        ShiroFilterFactoryBean bean = new ShiroFilterFactoryBean();
        // 设置 SecurityManager
        bean.setSecurityManager(securityManager);

        // 添加 Shiro 内置过滤器
        /*
         * anon: 无需认证即可访问
         * authc: 认证才能访问
         * user: 拥有 记住我 功能才能访问
         * perms: 拥有对某个资源的权限才可访问
         * role: 拥有某个角色才可访问
         */
        Map<String, String> filterMap = new HashMap<>();
        filterMap.put("/user/add", "authc");
        filterMap.put("/user/update", "authc");

        // 授权
        filterMap.put("/user/add", "perms[user-add]");
        filterMap.put("/user/update", "perms[user-update]");

        bean.setFilterChainDefinitionMap(filterMap);

        // 设置登陆请求
        bean.setLoginUrl("/toLogin");
        // 设置未授权跳转的界面
        bean.setUnauthorizedUrl("/noauth");

        return bean;
    }

    // Security Manager
    @Bean
    public DefaultWebSecurityManager getSecurityManager(@Qualifier("customRealm") CustomRealm customRealm) {
        DefaultWebSecurityManager defaultSecurityManager = new DefaultWebSecurityManager();
        defaultSecurityManager.setRealm(customRealm);
        return defaultSecurityManager;
    }

    // 自定义 Realm
    @Bean
    public CustomRealm customRealm() {
        return new CustomRealm();
    }

    // 整合 Shiro 和 Thymeleaf
    @Bean
    public ShiroDialect shiroDialect() {
        return new ShiroDialect();
    }
}
