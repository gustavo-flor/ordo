package com.github.gustavoflor.ordo.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication(scanBasePackages = "com.github.gustavoflor.ordo")
@EnableMongoRepositories(basePackages = "com.github.gustavoflor.ordo")
public class OrdoApiApplication {
    public static void main(String[] args) {
        SpringApplication.run(OrdoApiApplication.class, args);
    }
}
