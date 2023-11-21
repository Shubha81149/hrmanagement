package com.mca.hrmng.ServiceLayer;

import com.mca.hrmng.ManageDepartment;
import com.mca.hrmng.ManageDepartmentRepository;
import com.mca.hrmng.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.PublicKey;
import java.util.List;
import java.util.Optional;

@Service
public class ManageDepartmentServiceImp implements ManageDepartmentService {
    private ManageDepartmentRepository manageDepartmentRepository;
    @Autowired
    public ManageDepartmentServiceImp(ManageDepartmentRepository manageDepartmentRepository) {
        this.manageDepartmentRepository = manageDepartmentRepository;
    }
    @Override
    public ManageDepartment saveManageDepartment(ManageDepartment manageDepartment){
        return manageDepartmentRepository.save(manageDepartment);
    }
    @Override
    public List<ManageDepartment> getAllManageDepartment(){
        return manageDepartmentRepository.findAll();
    }
    @Override
    public ManageDepartment getManagementDepartmentById(Long id){
        Optional<ManageDepartment> md = manageDepartmentRepository.findById(id);
        if(md.isPresent()){
            return md.get();
        }else{
             throw new ResourceNotFoundException("ManagementDepartment","id",id);
        }
    }
    @Override
    public ManageDepartment updateManagementDepartment(ManageDepartment manageDepartment,Long mdid){
        ManageDepartment existingDepartment = manageDepartmentRepository.findById(mdid).orElseThrow(
                ()-> new ResourceNotFoundException("ManagementDepartment","id","mdid"));
        existingDepartment.setName(manageDepartment.getName());
        existingDepartment.setVacancy(manageDepartment.getVacancy());
        existingDepartment.setTotalDept(manageDepartment.getTotalDept());
        manageDepartmentRepository.save(existingDepartment);
        return existingDepartment;
    }
    @Override
    public  ManageDepartment deleteManagementDepartment(Long id){
        manageDepartmentRepository.deleteById(id);
        return null;
    }


}
