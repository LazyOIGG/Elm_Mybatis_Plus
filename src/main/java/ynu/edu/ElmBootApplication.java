package ynu.edu;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("ynu.edu.dao")
public class ElmBootApplication {
    public static void main(String[] args) {
        SpringApplication.run(ElmBootApplication.class, args);
    }
}
