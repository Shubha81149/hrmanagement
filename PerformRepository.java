package com.example.humanmanagement;

import com.example.humanmanagement.Model.Performance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PerformRepository extends JpaRepository<Performance ,Long > {
}
