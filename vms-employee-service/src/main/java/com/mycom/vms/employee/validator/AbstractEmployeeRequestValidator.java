package com.mycom.vms.employee.validator;

import com.mycom.vms.employee.exceptions.BadRequestException;
import com.mycom.vms.employee.model.EmployeeDto;

public abstract class AbstractEmployeeRequestValidator implements EmployeeRequestValidator {

    protected void validateBody (EmployeeDto employeeDto) {
        if (employeeDto.getFirstName() == null || employeeDto.getFirstName().isBlank()) {
            throw new BadRequestException("Employee's first name must not be empty. ");
        }
        if (employeeDto.getEmailId() == null || employeeDto.getEmailId().isBlank()) {
            throw new BadRequestException("Employee's email Id name must not be empty. ");
        }

    }

}
