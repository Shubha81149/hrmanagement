package com.example.humanmanagement.Controllerlayer;

import com.example.humanmanagement.Model.Compliance;

import com.example.humanmanagement.Servicelayer.ComplainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/com")
public class ComplainControl {

    private ComplainService complainService;


    @Autowired
    public  ComplainControl(ComplainService complainService){

        this.complainService=complainService;
    }
    @PostMapping
    public ResponseEntity<Compliance>saveCompliance(@RequestBody Compliance compliance){
        return  new ResponseEntity<Compliance>(complainService.saveCompliance(compliance), HttpStatus.CREATED);
    }

    @GetMapping
    public List<Compliance>getAll(){

        return  complainService.getAllCompliance();
    }



    @GetMapping("{id}")
    public ResponseEntity<Compliance>getCompliance(@PathVariable("id")Long id){

        return  new ResponseEntity<Compliance>(complainService.getComplianceById(id), HttpStatus.OK);
    }


    @PutMapping("{id}")
    public  ResponseEntity<Compliance>updateCompliance(@RequestBody Compliance compliance,@PathVariable("id")Long id){

        return  new ResponseEntity<Compliance>( complainService.updateCompliance(compliance,id),HttpStatus.OK);
    }
    @DeleteMapping("{id}")
    public  ResponseEntity<Compliance>deleteCompliance(@PathVariable("id")Long id){

        return  new ResponseEntity<Compliance>(complainService.deleteCompliance(id),HttpStatus.OK);
    }
}
