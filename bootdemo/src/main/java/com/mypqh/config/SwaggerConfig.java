package com.mypqh.config;

import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
//    http://localhost:8081/swagger-ui.html 访问web
//    http://localhost:8081/v2/api-docs 访问获取json格式
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2).pathMapping("/").select()
                .apis(RequestHandlerSelectors.basePackage("com.mypqh.controller"))
                .paths(PathSelectors.any()).build()
                .apiInfo(new ApiInfoBuilder().title("springboot add swagger")
                        .description("bootdemo详细API").build());
    }
}
