package com.malise.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AppApplication {

	public static void main(String[] args) {
		System.out.println("hello world");
		SpringApplication.run(AppApplication.class, args);
	}

}
