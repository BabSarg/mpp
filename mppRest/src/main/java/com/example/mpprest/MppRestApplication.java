package com.example.mpprest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = {"com.example.mpprest.*", "com.example.common.*"})
@EnableJpaRepositories(basePackages = "com.example.common.repository")
@EntityScan("com.example.common.model")
public class MppRestApplication {

    public static void main(String[] args) {
        SpringApplication.run(MppRestApplication.class, args);
    }

}
