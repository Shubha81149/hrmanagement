package com.example.humanmanagement.ServiceImplayer;


import com.example.humanmanagement.HumanRepository;
import com.example.humanmanagement.Model.Employee;
import com.example.humanmanagement.ResourceNotFoundException;
import com.example.humanmanagement.Servicelayer.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmpserviceImp implements EmpService {
    private HumanRepository humanRepository;

    @Autowired
    public EmpserviceImp(HumanRepository humanRepository) {
        this.humanRepository = humanRepository;
    }
    @Override
    public Employee saveEmployee(Employee employee) {
        return humanRepository.save(employee);
    }
    @Override
    public List<Employee> getAllEmployee() {
        return humanRepository.findAll();
    }
    @Override
    public Employee getEmployeeById(Long id) {
        Optional<Employee> employee = humanRepository.findById(id);
        if (employee.isPresent()) {
            return employee.get();
        } else {
            throw new ResourceNotFoundException("Employee", "id", id);
        }
    }
    @Override
    public Employee updateEmployee(Employee employee, Long staffid) {
        Employee existingEmployee = humanRepository.findById(staffid).orElseThrow(
                () -> new ResourceNotFoundException("Employee", "id", staffid));
        existingEmployee.setName(employee.getName());
        existingEmployee.setEmail(employee.getEmail());
        existingEmployee.setPhoneNo(employee.getPhoneNo());
        humanRepository.save(existingEmployee);
        return existingEmployee;
    }
    @Override
    public Employee deleteEmployee(Long id){
        humanRepository.deleteById(id);
        return null;
    }
}


