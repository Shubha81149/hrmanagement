package com.example.humanmanagement.Servicelayer;

import com.example.humanmanagement.Model.Leave;

import java.util.List;

public interface LeaveService {
    Leave saveLeave(Leave leave);

    List<Leave> getAllLeave();
    Leave getLeaveById(Long id);
    Leave deleteLeave(Long id);
    Leave updateLeave(Leave leave,Long lveid);
}
