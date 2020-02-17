package com.example.mppadmin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.example.common.repository")
@ComponentScan(basePackages = {"com.example.mppadmin", "com.example.common.*"})
@EntityScan("com.example.common.model")
public class MppAdminApplication {

    public static void main(String[] args) {
        SpringApplication.run(MppAdminApplication.class, args);
    }

}
