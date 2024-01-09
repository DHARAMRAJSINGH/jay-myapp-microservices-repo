package com.mycom.vms.employee.exceptions;

public class BadRequestException extends RuntimeException {

    public BadRequestException (String msg) {
        super(msg);
    }
}
