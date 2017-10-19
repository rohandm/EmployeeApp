/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rohan.emp.repository;

import com.rohan.emp.dataobjects.Employee;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * CRUD operations for employee table
 * @author rohan_000
 */
@Repository
public interface EmpRepository extends CrudRepository<Employee, Long> {
    public Employee findFirstByIdAndStatus(long empId, String status);
    public List<Employee> findByStatus(String status); 
}
