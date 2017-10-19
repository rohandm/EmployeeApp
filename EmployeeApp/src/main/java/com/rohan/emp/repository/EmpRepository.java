/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rohan.emp.repository;

import com.rohan.emp.dataobjects.Employee;
import java.util.List;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author rohan_000
 */
@Repository
public interface EmpRepository extends CrudRepository<Employee, Long> {
    public Employee findFirstById(long empId);
    public List<Employee> findByStatus(String status);
    
    /*@Modifying
    @Query("update Employee e set e.firstname = ?1, e.middleInitial?2, e.lastname = ?3, e.dateOfBirth?4, e.dateOfEmployment?5, e.status?6 where e.id = ?7")
    void updateEmp(String firstname, String middleInitial, String lastname, String dateOfBirth, String dateOfEmplyoment, String status, long id);*/
    
}
