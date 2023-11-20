package com.example.humanmanagement.ServiceImplayer;

import com.example.humanmanagement.ComplainRepository;
import com.example.humanmanagement.Model.Compliance;
import com.example.humanmanagement.ResourceNotFoundException;
import com.example.humanmanagement.Servicelayer.ComplainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class ComplainserviceImp implements ComplainService {

    private ComplainRepository complainRepository;
    @Autowired
    public  ComplainserviceImp(ComplainRepository complainRepository){

        this.complainRepository=complainRepository;
    }

    @Override
    public Compliance saveCompliance(Compliance compliance) {

        return complainRepository.save(compliance);
    }

    @Override
    public List<Compliance> getAllCompliance(){

        return  complainRepository.findAll();
    }


    @Override
    public  Compliance getComplianceById(Long id) {
        Optional<Compliance> compliance = complainRepository.findById(id);
        if (compliance.isPresent()) {
            return compliance.get();
        } else {
            throw new ResourceNotFoundException("compliance", "id", id);
        }
    }

    @Override
    public Compliance updateCompliance(Compliance compliance, Long id ){
        Compliance existingCompliance = complainRepository.findById(id).orElseThrow(
                ()-> new ResourceNotFoundException("Compliance","id",id));
        existingCompliance.setDepartment(compliance.getDepartment());
        existingCompliance.setName(compliance.getName());
        existingCompliance.setDescription(compliance.getDescription());
        existingCompliance.setDate(compliance.getDate());
        existingCompliance.setStatus(compliance.getStatus());
        complainRepository.save(existingCompliance);
        return  existingCompliance;

    }

    @Override
    public  Compliance deleteCompliance(Long id){
        complainRepository.deleteById(id);
        return  null;
    }






}
