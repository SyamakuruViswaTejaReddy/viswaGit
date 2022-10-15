package com.sp.restfulCurd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.sp.restfulCurd")
public class RestfulCurdApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestfulCurdApplication.class, args);
	}

}
