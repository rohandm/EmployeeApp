/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rohan.emp.service;

import com.rohan.emp.dataobjects.Employee;
import com.rohan.emp.exception.EmpAppException;
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
            return empRepository.findFirstByIdAndStatus(empId, STATUS_ACTIVE);
    }

    /**
     * Add new employee
     * @param emp 
     * @return  
     * @throws com.rohan.emp.exception.EmpAppException 
     */
    public Employee addEmployee(Employee emp) throws EmpAppException {
        emp.setStatus(STATUS_ACTIVE);
        emp = empRepository.save(emp);
        if(emp.getId() == 0){
            throw new EmpAppException("Unable to add employee "+emp);
        }
        return emp;
    }
    
    /**
     * Update employee details
     * @param emp 
     * @return  
     * @throws com.rohan.emp.exception.EmpAppException 
     */
    public Employee updateEmployee(Employee emp) throws EmpAppException{
        Employee emp1 = empRepository.findFirstByIdAndStatus(emp.getId(), STATUS_ACTIVE);
        if(emp1 == null){
            throw new EmpAppException("No active employee found "+emp1);
        }
        emp1.setFirstName(emp.getFirstName());
        emp1.setMiddleInitial(emp.getMiddleInitial());
        emp1.setLastName(emp.getLastName());
        emp1.setDateOfBirth(emp.getDateOfBirth());
        emp1.setDateOfEmployment(emp.getDateOfEmployment());
        return empRepository.save(emp1);
    }
    
    /**
     * Delete employee
     * @param empId 
     * @return  
     * @throws com.rohan.emp.exception.EmpAppException 
     */
    public Employee deleteEmployee(long empId) throws EmpAppException{
        Employee emp = empRepository.findFirstByIdAndStatus(empId, STATUS_ACTIVE);
        if(emp == null){
            throw new EmpAppException("No active employee found "+emp);
        }
        emp.setStatus(STATUS_INACTIVE);
        return empRepository.save(emp);
    }
    
    /**
     * Load initial data
     */
    public void loadData(){
        dataInitRepository.initData();
    }
}
