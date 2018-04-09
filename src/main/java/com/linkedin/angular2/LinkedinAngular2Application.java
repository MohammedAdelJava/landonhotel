package com.linkedin.angular2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@ComponentScan
public class LinkedinAngular2Application {
	
	
	public static void main(String[] args) {
		SpringApplication.run(LinkedinAngular2Application.class, args);	
			
	}
}
