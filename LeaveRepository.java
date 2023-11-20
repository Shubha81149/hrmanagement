package com.example.humanmanagement;

import com.example.humanmanagement.Model.Leave;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LeaveRepository  extends JpaRepository <Leave , Long> {


}
