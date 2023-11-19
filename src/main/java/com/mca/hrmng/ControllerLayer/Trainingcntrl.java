package com.mca.hrmng.ControllerLayer;

import com.mca.hrmng.ServiceLayer.TrainingService;
import com.mca.hrmng.Training;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/train")
public class Trainingcntrl {
    private TrainingService trainingService;

        @Autowired
        public  Trainingcntrl(TrainingService trainingService){
            this.trainingService = trainingService;
        }

        @PostMapping
        public ResponseEntity<Training> saveTraining(@RequestBody Training training){
            return  new ResponseEntity<Training>(trainingService.saveTraining(training), HttpStatus.CREATED);
        }

        @GetMapping
        public List<Training> getAllTraining(){
            return trainingService.getAllTraining();
        }

        @GetMapping("{id}")
        public ResponseEntity<Training>gettrain(@PathVariable("id") Long trainid){
            return  new ResponseEntity<Training>(trainingService.getTrainingById(trainid), HttpStatus.OK);
        }

        @PutMapping("{id}")
        public ResponseEntity<Training>updateTraining(@RequestBody Training training ,@PathVariable("id") Long trainid){
            return  new ResponseEntity<Training>(trainingService.updateTraining(training, trainid), HttpStatus.OK);
        }

        @DeleteMapping("{id}")
        public ResponseEntity<Training>deleteTraining(@PathVariable("id") Long trainid){
            return  new ResponseEntity<Training>(trainingService.deleteTraining(trainid), HttpStatus.OK);
        }

    }
