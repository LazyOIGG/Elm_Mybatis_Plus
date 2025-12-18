package ynu.edu.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.License;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Knife4jConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("饿了么外卖系统 API文档")
                        .description("基于SpringBoot + Vue的前后端分离外卖系统")
                        .version("v1.0")
                        .contact(new Contact()
                                .name("倪春阳")
                                .email("nichunyang2005@foxmail.com")
                                .url("https://github.com"))
                        .license(new License()
                                .name("Apache 2.0")
                                .url("http://www.apache.org/licenses/LICENSE-2.0")));
    }

    @Bean
    public GroupedOpenApi publicApi() {
        return GroupedOpenApi.builder()
                .group("public")  // 分组名称
                .packagesToScan("ynu.edu.controller")  // 扫描的包路径
                .pathsToMatch("/**")  // 匹配所有路径
                .build();
    }
}