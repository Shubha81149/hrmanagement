package com.example.humanmanagement.Servicelayer;

import com.example.humanmanagement.Model.Employee;

import java.util.List;

public interface  EmpService {
    Employee saveEmployee (Employee employee);

    List<Employee>getAllEmployee();
    Employee getEmployeeById(Long id);
    Employee deleteEmployee(Long id);

    Employee updateEmployee(Employee employee,Long staffid);
}
