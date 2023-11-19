package com.mca.hrmng.ServiceLayer;

import com.mca.hrmng.ResourceNotFoundException;
import com.mca.hrmng.SalaryRepository;
import com.mca.hrmng.Salary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SalaryServiceImp implements SalaryService{

    private SalaryRepository salaryRepository;

    @Autowired
    public SalaryServiceImp(SalaryRepository salaryRepository){

        this.salaryRepository = salaryRepository;
    }

    @Override
    public Salary saveSalary(Salary salary){
        return salaryRepository.save(salary);

    }
    @Override
    public List<Salary> getAllSalary(){
        return salaryRepository.findAll();

    }
    @Override
    public Salary getSalaryById(Long id){
        Optional<Salary> salary = salaryRepository.findById(id);
        if(salary.isPresent()){
            return salary.get();
        }else{
            throw new ResourceNotFoundException("Salary","id",id);
        }

    }
    @Override
    public Salary updateSalary(Salary salary, Long id){
        Salary existingSalary  = salaryRepository.findById(id).orElseThrow(
                ()-> new ResourceNotFoundException("Salary","id",id));
        existingSalary.setName(salary.getName());
        existingSalary.setDptm(salary.getDptm());
        existingSalary.setAmount(salary.getAmount());
        existingSalary.setComplain(salary.getComplain());
        salaryRepository.save(existingSalary);
        return existingSalary;

    }
    @Override
    public Salary deleteSalary(Long id){
        salaryRepository.deleteById(id);
        return null;

    }

}
