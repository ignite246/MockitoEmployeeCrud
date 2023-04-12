package com.infosys.ctadm.learning.services;

import com.infosys.ctadm.learning.dto.Employee;
import com.infosys.ctadm.learning.exceptions.EmployeeNotFoundException;

import java.util.List;

public interface EmployeeService {

    Long registerEmployee(Employee employee);
    Employee fetchEmployeeById(Long employeeId) throws EmployeeNotFoundException;
    List<Employee> fetchEmployeeHavingSameFirstName(String firstName);
    List<Employee> fetchAllEmployees();
    void removeEmployeeById(Long employeeId) throws EmployeeNotFoundException;
}
