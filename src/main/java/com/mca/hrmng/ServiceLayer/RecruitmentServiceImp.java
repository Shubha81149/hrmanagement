package com.mca.hrmng.ServiceLayer;

import com.mca.hrmng.Recruitment;
import com.mca.hrmng.RecruitmentRepository;
import com.mca.hrmng.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RecruitmentServiceImp implements RecruitmentService{
    private RecruitmentRepository recruitmentRepository;

    @Autowired
    public RecruitmentServiceImp(RecruitmentRepository recruitmentRepository) {
        this.recruitmentRepository = recruitmentRepository;
    }

    @Override
    public Recruitment saveRecruitment(Recruitment recruitment){

        return  recruitmentRepository.save(recruitment);
    }

     @Override
     public Recruitment getRecruitmentById(Long id){
         Optional<Recruitment> recruitment = recruitmentRepository.findById(id);
         if(recruitment.isPresent()){
             return recruitment.get();
         }else{
             throw new ResourceNotFoundException("Recruitment","id",id);
         }

     }
     @Override
     public List<Recruitment> getAllRecruitment(){
         return  recruitmentRepository.findAll();
     }

    @Override
    public Recruitment updateRecruitment(Recruitment recruitment,Long id){
        Recruitment existingRecruitment = recruitmentRepository.findById(id).orElseThrow(
                () ->new ResourceNotFoundException("Recruitment","id",id));

        existingRecruitment.setDepartment(recruitment.getDepartment());
        existingRecruitment.setExamtime(recruitment.getExamtime());
        existingRecruitment.setPost(recruitment.getPost());
        existingRecruitment.setQualification(recruitment.getQualification());
        existingRecruitment.setInterView(recruitment.getInterView());
        existingRecruitment.setStatus(recruitment.getStatus());
        recruitmentRepository.save(existingRecruitment);
        return existingRecruitment;
     }
     @Override
     public Recruitment deleteRecruitment(Long id){
         recruitmentRepository.deleteById(id);
           return  null;
    }
}
