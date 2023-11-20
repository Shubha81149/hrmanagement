package com.example.humanmanagement.Servicelayer;

import com.example.humanmanagement.Model.Performance;

import java.util.List;

public interface PerformService {

 Performance savePerformance(Performance performance);

    List<Performance>getAllPerformance();

    Performance getPerformanceById(Long id);
    Performance deletePerformance(Long id);
    Performance updatePerformance(Performance performance, Long id);
}
