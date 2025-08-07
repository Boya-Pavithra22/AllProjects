package com.wipro.springboot.springbootassignment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "com.wipro.springboot")
@EnableJpaRepositories(basePackages = "com.wipro.springboot.repository")
@EntityScan(basePackages = "com.wipro.springboot.model")
public class SpringbootAssignmentApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootAssignmentApplication.class, args);
	}

}
