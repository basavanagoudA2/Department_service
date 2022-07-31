package com.bm.world.dep.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandlerController {
    @ExceptionHandler(value = DepartmentIdNotFoundException.class)
    public ResponseEntity<ErrorMessage> depertmentNotFoundExcption(DepartmentIdNotFoundException departmentIdNotFoundException){
        ErrorMessage errorMessage=new ErrorMessage();
        errorMessage.setMessage(departmentIdNotFoundException.getErrorMessage());
        errorMessage.setStatusCode(HttpStatus.BAD_REQUEST.toString());
        return new ResponseEntity<ErrorMessage>(errorMessage, HttpStatus.BAD_REQUEST);
    }
}
