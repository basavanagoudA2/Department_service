package com.bm.world.dep.exception;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalTime;
@Getter
@Setter
public class DepartmentIdNotFoundException extends RuntimeException{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String errorMessage;
    LocalTime time;

    public DepartmentIdNotFoundException() {
    }

    public DepartmentIdNotFoundException(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public DepartmentIdNotFoundException(String message, String errorMessage) {
        super(message);
        this.errorMessage = errorMessage;
    }

    public DepartmentIdNotFoundException(String message, Throwable cause, String errorMessage) {
        super(message, cause);
        this.errorMessage = errorMessage;
    }

    public DepartmentIdNotFoundException(Throwable cause, String errorMessage) {
        super(cause);
        this.errorMessage = errorMessage;
    }

    public DepartmentIdNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace, String errorMessage) {
        super(message, cause, enableSuppression, writableStackTrace);
        this.errorMessage = errorMessage;
    }

    
}
