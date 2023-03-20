package com.infosys.ctadm.learning.services;

import com.infosys.ctadm.learning.dao.EmployeeDAO;
import com.infosys.ctadm.learning.dao.EmployeeDAOImpl;
import com.infosys.ctadm.learning.dto.Employee;

import java.util.List;

public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeDAO dao;

    public EmployeeServiceImpl() {
        this.dao = new EmployeeDAOImpl();
    }

    @Override
    public Long registerEmployee(Employee employee) {
        Employee registeredEmployee = dao.saveEmployee(employee);
        return registeredEmployee.getEmpId();
    }

    @Override
    public Employee fetchEmployeeById(Long employeeId) {
        Employee fetchedEmployee = dao.findEmployeeByEmployeeId(employeeId);
        return fetchedEmployee;
    }

    @Override
    public List<Employee> fetchEmployeeHavingSameFirstName(String firstName) {
        List<Employee> fetchedEmployeeWithSameFirstName = dao.findAllEmployeesWithSameFirstName(firstName);
        return fetchedEmployeeWithSameFirstName;
    }

    @Override
    public List<Employee> fetchAllEmployees() {
        List<Employee> allEmployees = dao.findAllEmployees();
        return allEmployees;
    }

    @Override
    public void removeEmployeeById(Long employeeId) {
        dao.deleteEmployeeByEmployeeId(employeeId);
    }
}
