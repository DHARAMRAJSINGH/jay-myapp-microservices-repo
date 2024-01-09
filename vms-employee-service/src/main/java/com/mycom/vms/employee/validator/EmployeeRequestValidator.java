package com.mycom.vms.employee.validator;

import com.mycom.vms.employee.model.EmployeeDto;

public interface EmployeeRequestValidator {

    void validateAddRequest (EmployeeDto employeeDto);
    void validateUpdateRequest (EmployeeDto employeeDto);

}
