package com.bm.world.dep.exception;

public class DepartmentsNotFoundException extends RuntimeException{
    public DepartmentsNotFoundException() {
    }

    public DepartmentsNotFoundException(String message) {
        super(message);
    }

    public DepartmentsNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public DepartmentsNotFoundException(Throwable cause) {
        super(cause);
    }

    public DepartmentsNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
