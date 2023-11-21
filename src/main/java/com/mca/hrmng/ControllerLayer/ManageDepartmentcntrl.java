package com.mca.hrmng.ControllerLayer;

import com.mca.hrmng.ManageDepartment;
import com.mca.hrmng.ServiceLayer.ManageDepartmentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/md")
public class ManageDepartmentcntrl {
    private ManageDepartmentService manageDepartmentService;

    public ManageDepartmentcntrl(ManageDepartmentService manageDepartmentService) {
        this.manageDepartmentService = manageDepartmentService;
    }
    @PostMapping
    public ResponseEntity<ManageDepartment>saveManagementDepartment(@RequestBody ManageDepartment manageDepartment){
        return new ResponseEntity<ManageDepartment>(manageDepartmentService.saveManageDepartment(manageDepartment),HttpStatus.CREATED);
    }
    @GetMapping
    public List<ManageDepartment>getAll(){
        return manageDepartmentService.getAllManageDepartment();
    }
    @GetMapping("{id}")
    public ResponseEntity<ManageDepartment>getManageDepartment(@PathVariable("id") Long mdid){
        return new ResponseEntity<ManageDepartment>(manageDepartmentService.getManagementDepartmentById(mdid), HttpStatus.OK);
    }
    @PutMapping("{id}")
    public ResponseEntity<ManageDepartment>updateManagementDepartment(@RequestBody ManageDepartment manageDepartment,@PathVariable("id") Long mdid){
        return new ResponseEntity<ManageDepartment>(manageDepartmentService.updateManagementDepartment(manageDepartment,mdid),HttpStatus.OK);
    }
    @DeleteMapping("{id}")
    public ResponseEntity<ManageDepartment>deleteManagementDepartment(@PathVariable("id") Long mdid){
        return new ResponseEntity<ManageDepartment>(manageDepartmentService.deleteManagementDepartment(mdid),HttpStatus.OK);
    }

}
