package com.bm.world.dep.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.bm.world.dep.ApplicationConstants;
import com.bm.world.dep.exception.DepartmentsNotFoundException;
import com.bm.world.dep.model.Department;
import com.bm.world.dep.model.request.DepartmentRequest;
import com.bm.world.dep.model.response.DepartmentResponse;
import com.bm.world.dep.repository.DepartmentRepository;

/**
 * This class used for perform the operation on Department
 */
@Service
public class DepartmentServiceImpl implements DepartmentService{
	private static final Logger LOG=LogManager.getLogger(DepartmentServiceImpl.class);
	@Autowired
    DepartmentRepository departmentRepository;
	/**
	 * This method used for saving the department details into database
	 */
    @Override
    public String saveDepartment(DepartmentRequest departmentRequest) {
    	LOG.info("Started the saving department details:[{}]",departmentRequest);
        Department department=new Department();
        BeanUtils.copyProperties(departmentRequest, department);
        department=departmentRepository.save(department);
        LOG.debug("competed the saving department details:[{}]",department);
        LOG.info("completed the inserting department details");
        return ApplicationConstants.DEPT_SAVE_MESSAGE +department.getDepartmentId();
    }
    /**
     * This method used for delete the department based on the departmentId
     */
	@Override
	public String deleteDepartment(Integer departmentId) {
		try {
			LOG.info("Started deleting the department details based on the departmentId :[{}]", departmentId);
			departmentRepository.deleteById(departmentId);

		} catch (EmptyResultDataAccessException exception) {
			throw new DepartmentsNotFoundException("department not found found for detete: " + departmentId);
		}
		LOG.debug("completed the deleting the department details");
		LOG.info("completed the deleting the department details");
		return ApplicationConstants.DEPT_DELETE_MESSAGE + departmentId;
	}
	/**
	 * This method used for update the department details based on the departmentId
	 */
	@Override
	public String updateDepartment(DepartmentRequest departmentRequest) {
		LOG.info("Started the update department details:[{}]",departmentRequest);
		Department department = departmentRepository.getReferenceById(departmentRequest.getDepartmentId());
		department.setDepartmentHead(departmentRequest.getDepartmentHead());
		department.setDepartmentName(departmentRequest.getDepartmentName());
		departmentRepository.save(department);
		LOG.debug("complted the update the department detials");
		LOG.info("completed the update the department detauils");
		return ApplicationConstants.DEPT_UPDATE_MESSAAGE + departmentRequest.getDepartmentId();
	}
	/**
	 * This method used for getting the all departments details
	 */
    @Override
    public List<DepartmentResponse> getAllDepartment() {
    	LOG.info("fetching the all department details");
        List<DepartmentResponse> departmentResponseList=null;
        departmentResponseList=new ArrayList<>();
        List<Department> departmentList=departmentRepository.findAll();
      if (!ObjectUtils.isEmpty(departmentList)){
          for (Department department:departmentList) {
              DepartmentResponse departmentResponse=new DepartmentResponse();
              departmentResponse.setDepartmentHead(department.getDepartmentHead());
              departmentResponse.setDepartmentName(department.getDepartmentName());
              departmentResponseList.add(departmentResponse);
              LOG.info("fetching the all department details:[{}]",departmentResponseList);
          }
      }else {
          throw new DepartmentsNotFoundException("Departments data not available. please check after few minutes");
      }
        departmentList.clear();
    	LOG.info("completed fetching the all department details");
        return departmentResponseList;
    }
    /**
     * This method used fetch the department based on the departmentId 
     */
    @Override
    public DepartmentResponse getDepartmentOnId(Integer departmentId) {
    	LOG.info("fetching the department details based on the departmentId:[{}]",departmentId);
    	DepartmentResponse departmentResponse=new DepartmentResponse();
    	Optional<Department> departmentOptional= departmentRepository.findById(departmentId);
        if(departmentOptional.isPresent()) {
        	BeanUtils.copyProperties(departmentOptional.get(), departmentResponse);        	
        }else {
            throw new DepartmentsNotFoundException("Departments data not available for this departmentId: "+departmentId);
        }
    	LOG.debug("completed fetching record based on the departmentId:[{}]",departmentResponse);
    	LOG.info("completed fetching the records based on departmentId");
    	return departmentResponse;
    }
}
