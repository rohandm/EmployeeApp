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
@RequestMapping("/employees")
public class EmpController {
    
    	@Autowired
	protected EmpService empService;

	protected Logger logger = LoggerFactory.getLogger(EmpController.class);

	/*public EmpController(EmpService empService) {
		this.empService = empService;
	}*/
    	/**
	 * Return all users
	 * 
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET, headers = "Accept=application/json")
	public List<Employee> findAllActiveEmployees() {
		return empService.findAllActiveEmployees();
	}

	/**
	 * Return user associated with specific user name
	 * 
	 * @param userName
	 * @return
	 */
	@RequestMapping(value = "{empId}", method = RequestMethod.GET, headers = "Accept=application/json")
	public Employee findEmployeeById(@PathVariable("empId") long empId) {
		return empService.findEmployeeById(empId);
	}
        
	/**
	 * Return user associated with specific user name
	 * 
	 * @param emp
	 * @return
	 */
	@RequestMapping(method = RequestMethod.POST, headers = "Accept=application/json")
	public void addEmployee(@RequestBody Employee emp) {
		empService.addEmployee(emp);
	}
        
	/**
	 * Return user associated with specific user name
	 * 
	 * @param emp
	 * @return
	 */
	@RequestMapping(method = RequestMethod.PUT, headers = "Accept=application/json")
	public void updateEmployee(@RequestBody Employee emp) {
		empService.updateEmployee(emp);
	}
        
	/**
	 * Return user associated with specific user name
	 * 
	 * @param emp
	 * @return
	 */
	@RequestMapping(method = RequestMethod.DELETE, headers = "Accept=application/json")
	public void deleteEmployee(@RequestBody Employee emp) {
		empService.deleteEmployee(emp);
	}
}
