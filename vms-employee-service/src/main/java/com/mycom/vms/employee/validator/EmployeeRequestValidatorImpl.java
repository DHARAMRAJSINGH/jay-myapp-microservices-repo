package com.mycom.vms.employee.validator;

import com.mycom.vms.employee.model.EmployeeDto;
import org.springframework.stereotype.Component;

@Component
public class EmployeeRequestValidatorImpl extends AbstractEmployeeRequestValidator {


    @Override
    public void validateAddRequest(EmployeeDto employeeDto) {
        if (employeeDto.getEmployeeId() != null && employeeDto.getEmployeeId().isBlank()) {
            employeeDto.setEmployeeId(null);
        }
        validateBody(employeeDto);
    }

    @Override
    public void validateUpdateRequest(EmployeeDto employeeDto) {
        validateBody(employeeDto);
    }

}
