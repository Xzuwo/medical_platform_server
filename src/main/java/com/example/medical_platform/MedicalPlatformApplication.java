package com.example.medical_platform;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.medical_platform.mapper")
public class MedicalPlatformApplication {

    public static void main(String[] args) {
        SpringApplication.run(MedicalPlatformApplication.class, args);
    }

}
