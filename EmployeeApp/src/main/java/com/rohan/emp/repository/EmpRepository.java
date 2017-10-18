/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rohan.emp.repository;

import com.rohan.emp.dataobjects.Employee;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author rohan_000
 */
public interface EmpRepository extends CrudRepository<Employee, Long> {
    public Employee findFirstById(String empId);
    public List<Employee> findByStatus();
    
}
