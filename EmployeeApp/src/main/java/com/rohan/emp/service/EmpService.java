/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rohan.emp.service;

import com.rohan.emp.dataobjects.Employee;
import com.rohan.emp.repository.DataInitRepository;
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
    //Employee repository
    private EmpRepository empRepository;
    
    //Data init repository used for initial load
    private DataInitRepository dataInitRepository;
    
    @Autowired
    public void setEmpRepository(EmpRepository empRep) {
        this.empRepository = empRep;
    }
    
    @Autowired
    public void setDataInitRepository(DataInitRepository dataInitRep) {
        this.dataInitRepository = dataInitRep;
    }
    //Active employee status
    public static final String STATUS_ACTIVE = "A";
    //Inactive employee status
    public static final String STATUS_INACTIVE = "I";

    /**
     * Retrieve all active employees
     * @return 
     */
    public List<Employee> findAllActiveEmployees() {
            return empRepository.findByStatus(STATUS_ACTIVE);
    }
    
    /**
     * Retrieve employee by id
     * @param empId
     * @return 
     */
    public Employee findEmployeeById(long empId) {
            return empRepository.findFirstById(empId);
    }

    /**
     * Add new employee
     * @param emp 
     */
    public void addEmployee(Employee emp) {
        emp.setStatus(STATUS_ACTIVE);
        empRepository.save(emp);
    }
    
    /**
     * Update employee details
     * @param emp 
     */
    public void updateEmployee(Employee emp){
        Employee emp1 = empRepository.findFirstById(emp.getId());
        if(emp1 != null){
            empRepository.save(emp);
        }
    }
    
    /**
     * Delete employee
     * @param empId 
     */
    public void deleteEmployee(long empId){
        Employee emp1 = empRepository.findFirstById(empId);
        if(emp1 != null){
            emp1.setStatus(STATUS_INACTIVE);
            empRepository.save(emp1);
        }
    }
    
    /**
     * Load initial data
     */
    public void loadData(){
        dataInitRepository.initData();
    }
}
