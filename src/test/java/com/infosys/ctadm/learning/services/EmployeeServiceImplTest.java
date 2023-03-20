package com.infosys.ctadm.learning.services;

import com.infosys.ctadm.learning.dao.EmployeeDAO;
import com.infosys.ctadm.learning.dao.EmployeeDAOImpl;
import com.infosys.ctadm.learning.dto.Employee;
import com.infosys.ctadm.learning.exceptions.EmployeeNotFoundException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class EmployeeServiceImplTest {

    @Mock
    EmployeeDAO dao = new EmployeeDAOImpl();

    @InjectMocks
    EmployeeService service = new EmployeeServiceImpl();


    @Test
    public void testRegisterEmployee() {

        Employee emp = new Employee(10L, "Aman", "Singh", "as@gmail.com");
        Mockito.when(dao.saveEmployee(emp)).thenReturn(emp);

        Long actualEmpId = service.registerEmployee(emp);

        Assertions.assertEquals(emp.getEmpId(), actualEmpId);
        Mockito.verify(dao).saveEmployee(emp);

    }

    @Test
    public void testFetchEmployeeById() throws EmployeeNotFoundException {

        final Long EMP_ID = 50L;
        Employee expectedEmp = new Employee(EMP_ID, "Akshay", "Phajage", "akp@gmail.com");
        Mockito.when(dao.findEmployeeByEmployeeId(EMP_ID)).thenReturn(expectedEmp);

        Employee actualEmp = service.fetchEmployeeById(EMP_ID);

        Assertions.assertEquals(expectedEmp,actualEmp);
        Mockito.verify(dao).findEmployeeByEmployeeId(EMP_ID);

    }

    @Test
    public void testFetchEmployeeHavingSameFirstName(){
        List<Employee> employees = new ArrayList<>(3);

        employees.add(new Employee(12L, "Raja", "Kumar", "rk@gmail.com"));
        employees.add(new Employee(21L, "Raja", "Sharma", "rs@hotmail.com"));
        employees.add(new Employee(35L, "Raja", "Kumar", "gk@outlook.com"));
        final String FIRST_NAME = "Raja";
        Mockito.when(dao.findAllEmployeesWithSameFirstName(FIRST_NAME)).thenReturn(employees);

        List<Employee> resultEmployees = service.fetchEmployeeHavingSameFirstName(FIRST_NAME);

        Assertions.assertEquals(employees,resultEmployees,"Results are mismatching");
        Mockito.verify(dao).findAllEmployeesWithSameFirstName(FIRST_NAME);

    }

    @Test
    public void testRemoveEmployeeById(){
        final Long EMP_ID = 100L;

        Mockito.doNothing().when(dao).deleteEmployeeByEmployeeId(Mockito.anyLong());

        service.removeEmployeeById(EMP_ID);

        Mockito.verify(dao).deleteEmployeeByEmployeeId(EMP_ID);
    }


}
