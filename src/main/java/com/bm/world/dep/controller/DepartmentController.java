package com.bm.world.dep.controller;

import com.bm.world.dep.ApplicationConstants;
import com.bm.world.dep.model.request.DepartmentRequest;
import com.bm.world.dep.model.response.DepartmentResponse;
import com.bm.world.dep.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * This controller used for perform operation on department
 */
@RestController
@RequestMapping(value = ApplicationConstants.BASE_URL)
public class DepartmentController {
    @Autowired
    DepartmentService departmentService;

    /**
     * This method used for save the department into database
     * @param departmentRequest
     * @return
     */
    @PostMapping(value = ApplicationConstants.SAVE_DEPT,consumes = "application/json")
    public ResponseEntity<String>  saveDept(@RequestBody DepartmentRequest departmentRequest){
        String saveResponse=departmentService.saveDepartment(departmentRequest);
        return new ResponseEntity<>(saveResponse, HttpStatus.ACCEPTED);
    }
    /**
     * This method used for delete the department
     * @param departmentId
     * @return
     */
    @DeleteMapping(value =ApplicationConstants.DELETE_DEPT )
    public ResponseEntity<String> deleteDept(@PathVariable Integer departmentId){
       String deleteResponse= departmentService.deleteDepartment(departmentId);
       return new ResponseEntity<>(deleteResponse,HttpStatus.OK);
    }

    /**
     * This method used for update the department
     * @param departmentRequest
     * @return
     */
    @PutMapping(value =ApplicationConstants.UPDATE_DEPT )
    public ResponseEntity<String> updateDept(@RequestBody DepartmentRequest departmentRequest){
        String updateResponse=departmentService.updateDepartment(departmentRequest);
        return new ResponseEntity<>(updateResponse,HttpStatus.OK);
    }

    /**
     * This method used for retrieve the all the department data
     * @return
     */
    @GetMapping(value =ApplicationConstants.GET_ALL_DEPT)
    public ResponseEntity< List<DepartmentResponse>> getAllDepartment(){
        return new ResponseEntity<>(departmentService.getAllDepartment(),HttpStatus.OK);
    }
    @GetMapping(value = ApplicationConstants.GET__DEPT_BY_ID)
    public ResponseEntity<DepartmentResponse> getDepartmentById(@PathVariable Integer departmentId) {
		return new ResponseEntity<>(departmentService.getDepartmentOnId(departmentId),HttpStatus.OK);
	}
}
