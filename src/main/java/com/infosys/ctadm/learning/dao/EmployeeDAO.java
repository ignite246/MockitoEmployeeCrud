package com.infosys.ctadm.learning.dao;

import com.infosys.ctadm.learning.dto.Employee;

import java.util.List;

/** @author Rahul Kumar */
/*
  This class has all the CRUD methods declared
 */

public interface EmployeeDAO {

    Employee saveEmployee(Employee employee);
    Employee findEmployeeByEmployeeId(Long employeeId);
    List<Employee> findAllEmployees();
    List<Employee> findAllEmployeesWithSameFirstName(String firstName);
    void deleteEmployeeByEmployeeId(Long employeeId);


}
