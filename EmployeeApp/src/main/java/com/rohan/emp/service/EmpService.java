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
import org.springframework.stereotype.Service;

/**
 *
 * @author rohan_000
 */
@Service
public class EmpService {
    @Autowired
    EmpRepository empRepository;
    
    public static final String STATUS_ACTIVE = "A";
    public static final String STATUS_INACTIVE = "I";
    
    public List<Employee> findAllActiveEmployees() {
            return empRepository.findByStatus(STATUS_ACTIVE);
    }
    
    public Employee findEmployeeById(long empId) {
            return empRepository.findFirstById(empId);
    }

    public void addEmployee(Employee emp) {
        emp.setStatus(STATUS_ACTIVE);
        empRepository.save(emp);
    }
    
    public void updateEmployee(Employee emp){
        Employee emp1 = empRepository.findFirstById(emp.getId());
        if(emp1 != null){
            empRepository.save(emp);
        }
    }
    
    public void deleteEmployee(Employee emp){
        Employee emp1 = empRepository.findFirstById(emp.getId());
        if(emp1 != null){
            emp1.setStatus(STATUS_INACTIVE);
            empRepository.save(emp1);
        }
    }
}
