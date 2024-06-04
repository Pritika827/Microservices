package com.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(scanBasePackages = "com.user")
public class UserServciesApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserServciesApplication.class, args);
	}

}
