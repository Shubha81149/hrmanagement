package com.example.humanmanagement.Controllerlayer;

import com.example.humanmanagement.Model.Employee;
import com.example.humanmanagement.Servicelayer.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/staff")
public class EmpControl {
    private EmpService empService;

    @Autowired
    public  EmpControl (EmpService empService){
        this.empService=empService;

    }
    @PostMapping
    public ResponseEntity<Employee>saveEmployee(@RequestBody Employee employee){
        return  new ResponseEntity<Employee>(empService.saveEmployee(employee), HttpStatus.CREATED);
    }
    @GetMapping
    public List<Employee>getAllEmployee(){
        return empService.getAllEmployee();
    }
    @GetMapping("{id}")
    public ResponseEntity<String> getstaff(@PathVariable("id")Long staffid){
        empService.getEmployeeById(staffid);
        return new ResponseEntity<String>("Add Successfully",HttpStatus.OK);
    }
    @PutMapping("{id}")
    public ResponseEntity<String> updateEmployee(@RequestBody Employee employee,@PathVariable("id")Long staffid){
        empService.updateEmployee(employee,staffid);
        return new ResponseEntity<String>("Update Successfully",HttpStatus.OK);
    }
    @DeleteMapping("{id}")
    public ResponseEntity<String>deleteEmployee(@PathVariable("id")Long staffid){
        empService.deleteEmployee(staffid);
        return new ResponseEntity<String>("Delete Successfully",HttpStatus.OK);
    }

}
