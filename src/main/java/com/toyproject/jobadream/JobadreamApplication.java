package com.toyproject.jobadream;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
// @EntityScan(basePackages = "com.toyproject.jobadream")
@PropertySource("classpath:env.properties")
public class JobadreamApplication {

	public static void main(String[] args) {
		SpringApplication.run(JobadreamApplication.class, args);
	}

}
