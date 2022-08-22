package com.zhang.practice.config;

import com.github.xiaoymin.knife4j.spring.annotations.EnableKnife4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;


@Configuration
@EnableSwagger2
@EnableKnife4j
public class Swagger2config {
    @Bean
    public Docket createRestApi(){
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.zhang.practice.controller"))
                .paths(PathSelectors.any())
                .build()
                .securitySchemes(securitySchmes());
    }
    private ApiInfo apiInfo(){
        return new ApiInfoBuilder()
                .title("实习生管理接口文档")
                .description("实习生管理")
                .contact(new Contact("张文亮","http:localhost:8243/doc.html","xxxx@xxx.com"))
                .version("1.0")
                .build();
    }
    private List<ApiKey> securitySchmes(){
        //设置请求头信息
        List<ApiKey> result= new ArrayList<>();
        ApiKey apiKey = new ApiKey("Authorization","Authorization","Header");
        result.add(apiKey);
        return result;
    }

}
