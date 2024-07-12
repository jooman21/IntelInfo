package com.custom.eaii.training;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication(scanBasePackages = "com.custom.eaii.training")

public class IntelInfoApplicationService {
    public static void main(String[] args) {


        SpringApplication.run(IntelInfoApplicationService.class, args);
    }
}

//, exclude = {SecurityAutoConfiguration.class}