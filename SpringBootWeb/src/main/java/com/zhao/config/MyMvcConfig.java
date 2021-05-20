package com.zhao.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Locale;

@Configuration
public class MyMvcConfig implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        // 首页映射
        registry.addViewController("/").setViewName("index");
        registry.addViewController("/index.html").setViewName("index");
        // 重定向登录成功后的页面
        registry.addViewController("/main.html").setViewName("dashboard");
    }

    // 自定义国际化, 方法名必须为 localeResolver
    // 因为 DispatcherServlet 类的 initLocaleResolver 方法中， getBean 指定了 beanName 为 localeResolver
    @Bean
    public LocaleResolver localeResolver() {
        return new MyLocaleResolver();
    }


    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginInterceptor())
                .addPathPatterns("/**")
                .excludePathPatterns("/", "/index.html", "/login", "/css/**", "/img/**", "/js/**");
    }
}
