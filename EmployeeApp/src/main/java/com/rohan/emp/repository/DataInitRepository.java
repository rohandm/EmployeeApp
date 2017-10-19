/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rohan.emp.repository;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * Repository used for loading initial data
 * @author rohan_000
 */
@Repository
public class DataInitRepository {

    //Datasource
    private DataSource dataSource;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    /**
     * Loads init data from csv file
     */
    public void initData() {
        String sql = "INSERT INTO EMPLOYEE(id, first_nm, MIDDLE_NM, last_nm, birth_dt, emp_start_dt, status)"
                + " SELECT id, first_nm, MIDDLE_NM, last_nm, birth_dt, emp_start_dt, status FROM CSVREAD('./data/init.csv')";
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        jdbcTemplate.update(sql, new Object[]{});

    }
}
