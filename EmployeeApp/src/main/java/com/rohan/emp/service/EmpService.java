/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rohan.emp.service;

import com.rohan.emp.dataobjects.Employee;
import com.rohan.emp.repository.EmpRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author rohan_000
 */
public class EmpService {
    @Autowired
    EmpRepository empRepository;
    
    public List<Employee> getActiveEmployees() {
            return empRepository.findByStatus();
    }
    
    public Employee findById(String empId) {
            return empRepository.findFirstById(empId);
    }

    public void add(Employee emp) {
        empRepository.save(emp);
    }
}
