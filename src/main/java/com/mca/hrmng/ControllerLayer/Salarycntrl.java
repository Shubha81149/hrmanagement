package com.mca.hrmng.ControllerLayer;

import com.mca.hrmng.Salary;
import com.mca.hrmng.ServiceLayer.SalaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/slry")
public class Salarycntrl {

    private SalaryService salaryService;

    @Autowired
    public  Salarycntrl(SalaryService salaryService){
        this.salaryService = salaryService;
    }

    @PostMapping
    public ResponseEntity<Salary>saveSalary(@RequestBody Salary salary){
        return  new ResponseEntity<Salary>(salaryService.saveSalary(salary), HttpStatus.CREATED);
    }

    @GetMapping
    public List<Salary> getAllSalary(){
        return salaryService.getAllSalary();
    }

    @GetMapping("{id}")
    public ResponseEntity<Salary>getslry(@PathVariable("id") Long id){
        return  new ResponseEntity<Salary>(salaryService.getSalaryById(id), HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<Salary>updateSalary(@RequestBody Salary salary ,@PathVariable("id") Long id){
        return  new ResponseEntity<Salary>(salaryService.updateSalary(salary, id), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Salary>deleteSalary(@PathVariable("id") Long id){
        return  new ResponseEntity<Salary>(salaryService.deleteSalary(id), HttpStatus.OK);
    }


}
