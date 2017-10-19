/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rohan.emp.controller;

import com.rohan.emp.dataobjects.Employee;
import com.rohan.emp.exception.EmpAppException;
import com.rohan.emp.service.EmpService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Controller class for employee CRUD operations
 *
 * @author rohan_000
 */
@RestController
@RequestMapping("/employees")
public class EmpController {

    //Employee service
    private EmpService empService;

    @Autowired
    protected void setEmpService(EmpService empSvc) {
        this.empService = empSvc;
    }

    protected static Logger logger = LoggerFactory.getLogger(EmpController.class);

    /*
     * Return all active employees, available to all users with role USER and higher
     *
     * @return
     */
    @RequestMapping(method = RequestMethod.GET, headers = "Accept=application/json")
    @PreAuthorize("hasRole('ROLE_USER')")
    public List<Employee> findAllActiveEmployees() {
        return empService.findAllActiveEmployees();
    }

    /**
     * Return employee with specified id, available to all users with ROLE USER and higher
     *
     * @param empId
     * @return
     */
    @RequestMapping(value = "{empId}", method = RequestMethod.GET, headers = "Accept=application/json")
    @PreAuthorize("hasRole('ROLE_USER')")
    public Employee findEmployeeById(@PathVariable("empId") long empId) {
        return empService.findEmployeeById(empId);
    }

    /**
     * Add new employee, available to users with ROLE ADMIN
     *
     * @param emp
     * @return
     * @throws com.rohan.emp.exception.EmpAppException
     */
    @RequestMapping(method = RequestMethod.POST, headers = "Accept=application/json")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public Employee addEmployee(@RequestBody Employee emp) throws EmpAppException {
        return empService.addEmployee(emp);
    }

    /**
     * Update employee details, available to users with ROLE SUPER_USER and higher
     *
     * @param emp
     * @return
     * @throws com.rohan.emp.exception.EmpAppException
     */
    @RequestMapping(method = RequestMethod.PUT, headers = "Accept=application/json")
    @PreAuthorize("hasRole('ROLE_SUPER_USER')")
    public Employee updateEmployee(@RequestBody Employee emp) throws EmpAppException {
        return empService.updateEmployee(emp);
    }

    /**
     * Deactivate employee, available to users with ROLE ADMIN
     *
     * @param empId
     * @return
     * @throws com.rohan.emp.exception.EmpAppException
     */
    @RequestMapping(value = "{empId}", method = RequestMethod.DELETE, headers = "Accept=application/json")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public Employee deleteEmployee(@PathVariable("empId") long empId) throws EmpAppException {
        return empService.deleteEmployee(empId);
    }

    /**
     * Load initial data, available to users with ROLE ADMIN
     */
    @RequestMapping(path = "/loadData", method = RequestMethod.GET)
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public void loadData() {
        empService.loadData();
    }
}
