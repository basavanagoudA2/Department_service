package com.bm.world.dep.service;

import com.bm.world.dep.model.request.DepartmentRequest;
import com.bm.world.dep.model.response.DepartmentResponse;

import java.util.List;

public interface DepartmentService {
    public String saveDepartment(DepartmentRequest departmentRequest);
    public String deleteDepartment(Integer departmentId);
    public String updateDepartment(DepartmentRequest departmentRequest);
    public List<DepartmentResponse> getAllDepartment();
    public DepartmentRequest getDepartmentOnId(Integer departmentId);
}
