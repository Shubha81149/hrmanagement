package com.mca.hrmng.ServiceLayer;

import com.mca.hrmng.Salary;

import java.util.List;

public interface SalaryService {

    Salary saveSalary(Salary salary);

    List<Salary> getAllSalary();
    Salary getSalaryById(Long id);
    Salary updateSalary(Salary salary, Long id);
    Salary deleteSalary(Long id);
}
