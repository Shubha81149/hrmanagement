package com.example.humanmanagement.Controllerlayer;


import com.example.humanmanagement.Model.Performance;
import com.example.humanmanagement.Servicelayer.PerformService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/perform")
public class PerformanceControl {

    private PerformService performService;
    @Autowired
    public PerformanceControl (PerformService performService){

        this.performService=performService;
    }
    @PostMapping
    public ResponseEntity<Performance>savePerformance(@RequestBody Performance performance){
        return  new ResponseEntity<Performance>(performService.savePerformance(performance), HttpStatus.CREATED);
    }

    @GetMapping
    public List<Performance>   getAll(){

        return  performService.getAllPerformance();
    }
   @GetMapping("{id}")
   public ResponseEntity<Performance>getperform(@PathVariable("id") Long id){

        return  new ResponseEntity<Performance>(performService.getPerformanceById(id), HttpStatus.OK);
   }


   @PutMapping("{id}")
    public  ResponseEntity<Performance>updatePerformance(@RequestBody Performance performance,@PathVariable("id")Long id){

        return  new ResponseEntity<Performance>(performService.updatePerformance(performance,id),HttpStatus.OK);

   }
   @DeleteMapping("{id}")
    public  ResponseEntity<Performance>deletePerformance(@PathVariable("id")Long id){

        return  new ResponseEntity<Performance>(performService.deletePerformance(id),HttpStatus.OK);
   }


}
