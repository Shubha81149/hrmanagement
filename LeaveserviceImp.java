package com.example.humanmanagement.ServiceImplayer;

import com.example.humanmanagement.LeaveRepository;
import com.example.humanmanagement.Model.Leave;
import com.example.humanmanagement.ResourceNotFoundException;
import com.example.humanmanagement.Servicelayer.LeaveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LeaveserviceImp implements LeaveService {
    private LeaveRepository leaveRepository;
    @Autowired
    public LeaveserviceImp(LeaveRepository leaveRepository){

        this.leaveRepository=leaveRepository;
    }

    @Override
    public Leave saveLeave(Leave leave){

        return leaveRepository.save(leave);
    }

    @Override
    public List<Leave>getAllLeave(){

        return leaveRepository.findAll();
    }
    @Override
    public Leave getLeaveById(Long id){
        Optional<Leave>leave = leaveRepository.findById(id);
        if (leave.isPresent()){
            return leave.get();
        }else {
            throw new ResourceNotFoundException("Leave","id",id);
        }
    }
    @Override
    public Leave updateLeave(Leave leave, Long lveid){
        Leave existingLeave = leaveRepository.findById(lveid).orElseThrow(
                ()-> new ResourceNotFoundException("Leave","id",lveid));
        existingLeave.setName(leave.getName());
        existingLeave.setEmail(leave.getEmail());
        existingLeave.setDept(leave.getDept());
        existingLeave.setReason(leave.getReason());
        leaveRepository.save(existingLeave);
        return existingLeave;

    }
    @Override
    public Leave deleteLeave(Long id){
        leaveRepository.deleteById(id);
        return  null;
    }

}
