package com.mca.hrmng.ServiceLayer;

import com.mca.hrmng.ManageDepartment;

import java.util.List;

public interface ManageDepartmentService {

    ManageDepartment saveManageDepartment(ManageDepartment manageDepartment);
    List<ManageDepartment> getAllManageDepartment();
    ManageDepartment getManagementDepartmentById(Long id);
    ManageDepartment updateManagementDepartment(ManageDepartment manageDepartment,Long mdid);
    ManageDepartment deleteManagementDepartment(Long id);
}
