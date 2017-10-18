/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rohan.emp.controller;

import com.rohan.emp.dataobjects.Employee;
import com.rohan.emp.service.EmpService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author rohan_000
 */
@RestController
@RequestMapping("/employee")
public class EmpController {
    
    	@Autowired
	protected EmpService empService;

	protected Logger logger = LoggerFactory.getLogger(EmpController.class);

	public EmpController(EmpService empService) {
		this.empService = empService;
	}
    	/**
	 * Return all users
	 * 
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET, headers = "Accept=application/json")
	public List<Employee> getActiveEmployees() {
		return empService.getActiveEmployees();
	}

	/**
	 * Return user associated with specific user name
	 * 
	 * @param userName
	 * @return
	 */
	@RequestMapping(value = "{empId}", method = RequestMethod.GET, headers = "Accept=application/json")
	public Employee findById(@PathVariable("empId") String empId) {
		return empService.findById(empId);
	}
        
	/**
	 * Return user associated with specific user name
	 * 
	 * @param userName
	 * @return
	 */
	@RequestMapping(value = "/add", method = RequestMethod.POST, headers = "Accept=application/json")
	public void findById(@RequestBody Employee emp) {
		empService.add(emp);
	}
}
