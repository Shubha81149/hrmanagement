package com.mca.hrmng.ServiceLayer;

import com.mca.hrmng.Recruitment;

import java.util.List;

public interface RecruitmentService {


    Recruitment saveRecruitment(Recruitment recruitment);
    Recruitment getRecruitmentById(Long id);
    List<Recruitment> getAllRecruitment();
    Recruitment updateRecruitment(Recruitment recruitment,Long id);
    Recruitment deleteRecruitment(Long id);
}
