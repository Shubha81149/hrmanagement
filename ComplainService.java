package com.example.humanmanagement.Servicelayer;

import com.example.humanmanagement.Model.Compliance;

import java.util.List;

public interface ComplainService {

    Compliance saveCompliance(Compliance compliance);
    List<Compliance>getAllCompliance();
    Compliance getComplianceById(Long id);
    Compliance deleteCompliance(Long id);
    Compliance updateCompliance(Compliance compliance, Long complainid);
}
