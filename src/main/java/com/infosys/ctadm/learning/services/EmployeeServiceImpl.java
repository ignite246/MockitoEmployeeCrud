package com.infosys.ctadm.learning.services;

import com.infosys.ctadm.learning.dao.EmployeeDAO;
import com.infosys.ctadm.learning.dao.EmployeeDAOImpl;
import com.infosys.ctadm.learning.dto.Employee;
import com.infosys.ctadm.learning.exceptions.EmployeeNotFoundException;

import java.util.List;
import java.util.Objects;

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
    public Employee fetchEmployeeById(Long employeeId) throws EmployeeNotFoundException {
        Employee fetchedEmployee = dao.findEmployeeByEmployeeId(employeeId);
        if(Objects.isNull(fetchedEmployee))
        {
            throw new EmployeeNotFoundException("Employee not found for given emp id : "+employeeId);
        }
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
    public void removeEmployeeById(Long employeeId) throws EmployeeNotFoundException {
        dao.deleteEmployeeByEmployeeId(employeeId);
    }
}
