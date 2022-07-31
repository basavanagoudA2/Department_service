package com.bm.world.dep.service;

import com.bm.world.dep.ApplicationConstants;
import com.bm.world.dep.exception.DepartmentIdNotFoundException;
import com.bm.world.dep.exception.DepartmentsNotFoundException;
import com.bm.world.dep.model.Department;
import com.bm.world.dep.model.request.DepartmentRequest;
import com.bm.world.dep.model.response.DepartmentResponse;
import com.bm.world.dep.repository.DepartmentRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

/**
 * This class used for perform the operation on Department
 */
@Service
public class DepartmentServiceImpl implements DepartmentService{
    @Autowired
    DepartmentRepository departmentRepository;
    @Override
    public String saveDepartment(DepartmentRequest departmentRequest) {
        Department department=new Department();
        BeanUtils.copyProperties(departmentRequest, department);
        department=departmentRepository.save(department);
        return ApplicationConstants.DEPT_SAVE_MESSAGE +department.getDepartmentId();
    }

    @Override
    public String deleteDepartment(Integer departmentId) throws DepartmentIdNotFoundException {
           //Department department=departmentRepository.getReferenceById(departmentId);
            try{
                departmentRepository.deleteById(departmentId);
            }catch (DataAccessException e){
                throw new DepartmentIdNotFoundException("DeptId not found:"+departmentId);
            }
        return ApplicationConstants.DEPT_DELETE_MESSAGE+departmentId;
    }

    @Override
    public String updateDepartment(DepartmentRequest departmentRequest) {
        try {
            Department department = departmentRepository.getReferenceById(departmentRequest.getDepartmentId());
            department.setDepartmentHead(departmentRequest.getDepartmentHead());
            department.setDepartmentName(departmentRequest.getDepartmentName());
            departmentRepository.save(department);

        } catch (EntityNotFoundException exception) {
            throw new DepartmentIdNotFoundException("Department not found for this deptId:\t" + departmentRequest.getDepartmentId());

        }
        return ApplicationConstants.DEPT_UPDATE_MESSAAGE + departmentRequest.getDepartmentId();
    }

    @Override
    public List<DepartmentResponse> getAllDepartment() {
        List<DepartmentResponse> departmentResponseList=null;
        departmentResponseList=new ArrayList<>();
        List<Department> departmentList=departmentRepository.findAll();
      if (!ObjectUtils.isEmpty(departmentList)){
          for (Department department:departmentList) {
              DepartmentResponse departmentResponse=new DepartmentResponse();
              departmentResponse.setDepartmentHead(department.getDepartmentHead());
              departmentResponse.setDepartmentName(department.getDepartmentName());
              departmentResponseList.add(departmentResponse);
          }
      }else {
          throw new DepartmentsNotFoundException("Departments data not available. please check after few minutes");
      }
        departmentList.clear();
        return departmentResponseList;
    }

    @Override
    public DepartmentRequest getDepartmentOnId(Integer departmentId) {
        return null;
    }
}
