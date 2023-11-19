package com.mca.hrmng.ServiceLayer;

import com.mca.hrmng.Training;
import org.springframework.stereotype.Service;

import java.util.List;


public interface TrainingService {

    Training saveTraining(Training training);
    Training deleteTraining(Long id);
    Training getTrainingById(Long id);
    List<Training> getAllTraining();
    Training updateTraining(Training training, Long trainid);
}
