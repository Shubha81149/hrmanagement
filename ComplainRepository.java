package com.example.humanmanagement;

import com.example.humanmanagement.Model.Compliance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ComplainRepository extends JpaRepository<Compliance,Long> {
}
