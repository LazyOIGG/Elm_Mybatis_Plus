package ynu.edu.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")          // ① 匹配所有API路径
                .allowedOrigins("*")            // ② 允许所有来源的请求
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")  // ③ 允许的HTTP方法
                .allowedHeaders("*")            // ④ 允许所有请求头
                .allowCredentials(false)        // ⑤ 不允许携带Cookie等凭证信息
                .maxAge(3600);                  // ⑥ 预检请求缓存时间
    }
}

/*各配置项的作用
① addMapping("/**")
对所有API路径应用跨域配置

可以使用 "/api/**" 等更具体的路径限制

② allowedOrigins("*")
允许所有域名访问（通配符）

⚠️ 安全问题：生产环境建议替换为具体的域名

java
.allowedOrigins("https://example.com", "https://api.example.com")
③ allowedMethods(...)
允许的HTTP请求方法

包括RESTful常用的方法

OPTIONS 方法用于CORS预检请求

④ allowedHeaders("*")
允许客户端发送所有请求头

可以具体指定："Content-Type", "Authorization"等

⑤ allowCredentials(false)
设置为 false：不允许携带Cookie、HTTP认证等凭证信息

如果需要凭证，需设置为 true，同时 allowedOrigins 不能是 "*"

⑥ maxAge(3600)
预检请求（OPTIONS）的结果缓存1小时

减少浏览器重复发送预检请求*/