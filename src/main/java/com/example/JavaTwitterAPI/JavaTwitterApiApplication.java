package com.example.JavaTwitterAPI;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.example.*")
public class JavaTwitterApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(JavaTwitterApiApplication.class, args);
	}

}
