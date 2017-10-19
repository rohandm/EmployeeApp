/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rohan.emp.config;

import com.rohan.emp.repository.EmpRepository;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * Configuration class
 * @author rohan_000
 */
@Configuration
@ComponentScan(basePackages = "com.rohan.emp")
@EnableJpaRepositories(basePackageClasses=EmpRepository.class)
@PropertySource("classpath:application.properties")
public class EmpConfig {

	public EmpConfig() {
	}
}
