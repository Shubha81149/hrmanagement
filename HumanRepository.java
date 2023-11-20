package com.example.humanmanagement;

import com.example.humanmanagement.Model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;


public interface HumanRepository extends JpaRepository<Employee,Long> {

}


