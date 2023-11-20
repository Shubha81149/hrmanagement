package com.example.humanmanagement.ServiceImplayer;

import com.example.humanmanagement.Model.Performance;
import com.example.humanmanagement.PerformRepository;
import com.example.humanmanagement.ResourceNotFoundException;
import com.example.humanmanagement.Servicelayer.PerformService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PerformserviceImp implements PerformService {

   private PerformRepository performRepository;
   @Autowired
    public  PerformserviceImp(PerformRepository performRepository){

       this.performRepository=performRepository;
   }



    @Override
    public Performance savePerformance(Performance performance) {
        return performRepository.save(performance);
    }



    @Override
   public List<Performance>getAllPerformance(){

       return  performRepository.findAll();
   }
   @Override
   public  Performance getPerformanceById(Long id) {
      Optional<Performance> performance = performRepository.findById(id);
      if (performance.isPresent()) {
         return performance.get();
      } else {
         throw new ResourceNotFoundException("Performance", "id", id);
      }
   }

      @Override
              public Performance updatePerformance(Performance performance, Long id ){
         Performance existingPerformance = performRepository.findById(id).orElseThrow(
                 ()-> new ResourceNotFoundException("Performance","id",id));
         existingPerformance.setName(performance.getName());
         existingPerformance.setDepartment(performance.getDepartment());
         existingPerformance.setGrade(performance.getGrade());
         performRepository.save(existingPerformance);
         return  existingPerformance;

      }

     @Override
             public  Performance deletePerformance(Long id){
         performRepository.deleteById(id);
         return  null;
      }




}
