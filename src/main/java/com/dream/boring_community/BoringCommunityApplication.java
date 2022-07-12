package com.dream.boring_community;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan("com.dream.boring_community.infrastructure.mapper")
public class BoringCommunityApplication {

    public static void main(String[] args) {
        SpringApplication.run(BoringCommunityApplication.class, args);
    }

}
