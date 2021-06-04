package com.zhao.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.env.Profiles;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.oas.annotations.EnableOpenApi;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
@EnableOpenApi
public class SwaggerConfig {

    @Bean
    public Docket docket(Environment env) {

        // 获取 dev 环境
        Profiles profile = Profiles.of("dev");
        // 通过 Environment.acceptsProfiles 判断是否处于 dev 环境
        boolean isDev = env.acceptsProfiles(profile);

        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .groupName("group 0")
                // 是否启动 Swagger
                .enable(isDev)
                .select()
                /*
                 * 配置扫描接口的方式
                 * basePackage：指定包
                 * any, none
                 * withClassAnnotation：扫描类上的注解
                 * withMethodAnnotation：扫描方法上的注解
                 */
                .apis(RequestHandlerSelectors.basePackage("com.zhao.controller"))
                // 扫描访问路径下的接口
                .paths(PathSelectors.ant("/**"))
                .build();
    }

    @Bean
    public Docket docket1() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("group 1");
    }

    @Bean
    public Docket docket2() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("group 2");
    }

    // 配置 Swagger 信息
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Swagger-UI")
                .description("Swagger-UI Test")
                .version("0.0.1")
                .termsOfServiceUrl("https://haozhangms.github.io")
                .contact(new Contact("admin", null, "123456@gmail.com"))  // 作者信息
                .build();
    }

}
