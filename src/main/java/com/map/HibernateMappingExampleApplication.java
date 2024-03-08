package com.map;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;

@SpringBootApplication

public class HibernateMappingExampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(HibernateMappingExampleApplication.class, args);
		System.out.println("calling...");
	}

}
