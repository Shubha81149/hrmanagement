package com.mca.hrmng.ServiceLayer;

import com.mca.hrmng.ResourceNotFoundException;
import com.mca.hrmng.TrainRepository;
import com.mca.hrmng.Training;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TrainingServiceImp implements TrainingService{
    private TrainRepository trainRepository;

    @Autowired
    public TrainingServiceImp(TrainRepository trainRepository){
        this.trainRepository = trainRepository;
    }

    @Override
    public Training saveTraining(Training training){
        return trainRepository.save(training);

    }
    @Override
    public Training getTrainingById(Long id){
        Optional<Training> training = trainRepository.findById(id);
        if(training.isPresent()){
            return training.get();
        }else{
            throw new ResourceNotFoundException("Training","id",id);
        }

    }
    @Override
    public List<Training> getAllTraining(){
        return trainRepository.findAll();

    }
    @Override
    public Training updateTraining(Training training, Long trainid){
        Training existingtraining = trainRepository.findById(trainid).orElseThrow(
                () -> new ResourceNotFoundException("Training","id",trainid));
        existingtraining.setName(training.getName());
        existingtraining.setType(training.getType());
        existingtraining.setProbation(training.getProbation());
        trainRepository.save(existingtraining);
        return existingtraining;
        }

    @Override
    public Training deleteTraining(Long id) {
        trainRepository.deleteById(id);
        return null;
    }
}
