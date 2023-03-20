package com.infosys.ctadm.learning.dao;

import com.infosys.ctadm.learning.dto.Employee;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class EmployeeDAOImpl implements EmployeeDAO {


    static List<Employee> employees;

    static {
        employees = new ArrayList<Employee>();
        employees.add(new Employee(1L, "Rahul", "Kumar", "rk@gmail.com"));
        employees.add(new Employee(2L, "Rahul", "Sharma", "rs@hotmail.com"));
        employees.add(new Employee(3L, "Gangu", "Kumar", "gk@outlook.com"));
        System.out.println("Total Employees At First ==> "+employees.size());
    }

    @Override
    public Employee saveEmployee(Employee employee) {
        System.out.println("STARTS ===> Saving Employee");

        employees.add(employee);

        System.out.println("ENDS ===> Saving Employee");
        System.out.println("Total Employee after adding one ==> "+employees.size());
        return employee;
    }

    @Override
    public Employee findEmployeeByEmployeeId(Long employeeId) {
        System.out.println("STARTS ===> Fetching Employee By Id : "+employeeId);
        Optional<Employee> optionalEmployee = employees.stream()
                .filter(employee -> employee.getEmpId().equals(employeeId)).findFirst();
        if (optionalEmployee.isPresent()) {
            System.out.println("ENDS ===> Fetching EmployeeById ==> Success");
            return optionalEmployee.get();
        } else {
            System.out.println("ENDS ===> Fetching EmployeeById ==> Exception");
            throw new RuntimeException("No employees could be found with given employee Id : " + employeeId);
        }


    }

    @Override
    public List<Employee> findAllEmployees() {
        System.out.println("STARTS ==> Fetching All Employees");
        return employees;
    }

    @Override
    public List<Employee> findAllEmployeesWithSameFirstName(String firstName) {
        List<Employee> employeesWithSimilarFirstName = employees.stream()
                .filter(employee -> employee.getFirstName().equals(firstName))
                .collect(Collectors.toList());
        return employeesWithSimilarFirstName;
    }

    @Override
    public void deleteEmployeeByEmployeeId(Long employeeId) {
        Employee employeeFound = findEmployeeByEmployeeId(employeeId);
        employees.remove(employeeFound);
    }
}
