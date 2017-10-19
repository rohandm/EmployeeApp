/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rohan.emp.config;

import com.rohan.emp.repository.EmpRepository;
import javax.sql.DataSource;
import javax.persistence.EntityManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;

/**
 *
 * @author rohan_000
 */
@Configuration
@ComponentScan(basePackages = "com.rohan.emp")
@EnableJpaRepositories(basePackageClasses=EmpRepository.class)
@PropertySource("classpath:application.properties")
public class EmpConfig {
    
	protected Logger logger = LoggerFactory.getLogger(EmpConfig.class);

	public EmpConfig() {
	}
}
