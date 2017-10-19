package com.rohan.emp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * Application class
 * @author rohan_000
 */
@SpringBootApplication
@ComponentScan(basePackages = "com.rohan.emp")
public class EmpApp {

	public static void main(String[] args) {
		SpringApplication.run(EmpApp.class, args);
	}
}
