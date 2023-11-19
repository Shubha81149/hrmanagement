package com.mca.hrmng.ControllerLayer;

import com.mca.hrmng.Recruitment;
import com.mca.hrmng.ServiceLayer.RecruitmentService;
import com.mca.hrmng.ServiceLayer.SalaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/recruit")
public class Recruitmentcntrl {
    private RecruitmentService recruitmentService;
    @Autowired
    public Recruitmentcntrl(RecruitmentService recruitmentService) {
        this.recruitmentService = recruitmentService;
    }
    @PostMapping
    public ResponseEntity<Recruitment> saveRecruitment(@RequestBody Recruitment recruitment){
        return new ResponseEntity<Recruitment>(recruitmentService.saveRecruitment(recruitment), HttpStatus.CREATED);
    }
    @GetMapping
    public List<Recruitment> getAll(){
        return recruitmentService.getAllRecruitment();
    }


    @GetMapping("{id}")
    public ResponseEntity<Recruitment> getRecruitment(@PathVariable ("id") Long id){
        return new ResponseEntity<Recruitment>(recruitmentService.getRecruitmentById(id),HttpStatus.OK);
    }


    @PutMapping("{id}")
    public ResponseEntity<Recruitment> updateRecruitment(@RequestBody Recruitment recruitment,@PathVariable("id") Long id){
        return new ResponseEntity<Recruitment>(recruitmentService.updateRecruitment(recruitment,id),HttpStatus.OK);
    }
    @DeleteMapping("{id}")
    public ResponseEntity<Recruitment> deleteRecruitment(@PathVariable("id") Long id){
        return new ResponseEntity<Recruitment>(recruitmentService.deleteRecruitment(id),HttpStatus.OK);
    }
}
