package com.fastgrill.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(
        scanBasePackages = { "com.fastgrill.api", "com.fastgrill.core" }
)
@EntityScan("com.fastgrill.core")
@EnableJpaRepositories(basePackages = "com.fastgrill.core")
public class FastGrillApiApplication {
    public static void main(String[] args) {

        SpringApplication.run(FastGrillApiApplication.class, args);

    }

}
