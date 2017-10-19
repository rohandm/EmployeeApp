package com.rohan.emp;

import com.rohan.emp.repository.EmpRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = "com.rohan.emp")
public class EmpApp {

	public static void main(String[] args) {
		SpringApplication.run(EmpApp.class, args);
	}
}
