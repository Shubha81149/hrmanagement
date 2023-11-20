package com.example.humanmanagement.Controllerlayer;

import com.example.humanmanagement.Model.Leave;
import com.example.humanmanagement.Servicelayer.LeaveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/lve")
public class LeaveControl {
    private LeaveService leaveService;

    @Autowired
    public  LeaveControl (LeaveService leaveService){
        this.leaveService=leaveService;
    }
    @PostMapping
    public ResponseEntity<Leave>saveLeave(@RequestBody Leave leave){
        return  new ResponseEntity<Leave>(leaveService.saveLeave(leave), HttpStatus.CREATED);
    }
    @GetMapping
    public List<Leave>getAllLeave(){
        return leaveService.getAllLeave();
    }
    @GetMapping("{id}")
    public ResponseEntity<String>getLeave(@PathVariable("id")Long lveid){
        leaveService.getLeaveById(lveid);
        return  new ResponseEntity<String>("Add successfully",HttpStatus.OK);
    }
    @PutMapping("{id}")
    public  ResponseEntity<String>updateLeave(@RequestBody Leave leave,@PathVariable("id")Long lveid){
        leaveService.updateLeave(leave,lveid);
        return new ResponseEntity<String>( "Update successfully",HttpStatus.OK);
    }
    @DeleteMapping("{id}")
    public  ResponseEntity<String>deleteLeave(@PathVariable("id")Long lveid){
        leaveService.deleteLeave(lveid);
        return new ResponseEntity<String>("Delete successfully",HttpStatus.OK);
    }

}
