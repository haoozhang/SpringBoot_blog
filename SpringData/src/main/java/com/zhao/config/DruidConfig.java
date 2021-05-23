package com.zhao.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewFilter;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.apache.catalina.manager.StatusManagerServlet;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.util.HashMap;

@Configuration
public class DruidConfig {

    /*
     * 自定义 Druid 数据源并添加到容器中，不再让 Spring Boot 自动创建
     * @ConfigurationProperties 作用是将配置文件中相同前缀的属性值，映射到 DruidDataSource 的同名参数中
     */
    @Bean
    @ConfigurationProperties("spring.datasource")
    public DataSource druidDataSource() {
        return new DruidDataSource();
    }

    /*
     * Spring Boot 内置了 Servlet 容器，所以没有 web.xml，我们用替代类 ServletRegistrationBean
     */
    @Bean
    public ServletRegistrationBean statViewServlet() {
        ServletRegistrationBean<StatViewServlet> bean = new ServletRegistrationBean<>(new StatViewServlet(), "/druid/*");
        // key 参数可以在 StatViewServlet 的父类 ResourceServlet 中查看
        HashMap<String, String> initParams = new HashMap<>();

        // 设置后台监控界面的账户密码
        initParams.put("loginUsername", "admin");
        initParams.put("loginPassword", "123456");
        // 允许谁可以访问
        initParams.put("allow", "");
        // 禁止谁访问
        // initParams.put("deny", )

        bean.setInitParameters(initParams);
        return bean;
    }

    @Bean
    public FilterRegistrationBean webStatFilter() {
        FilterRegistrationBean bean = new FilterRegistrationBean();
        bean.setFilter(new WebStatFilter());
        HashMap<String, String> initParams = new HashMap<>();

        // 这些不统计
        initParams.put("exclusions", "*.js,*.css,/druid/*");

        bean.setInitParameters(initParams);
        return bean;
    }

}
