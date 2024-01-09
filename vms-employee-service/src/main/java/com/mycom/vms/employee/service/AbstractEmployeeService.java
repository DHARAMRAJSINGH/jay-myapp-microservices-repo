package com.mycom.vms.employee.service;

import com.mycom.vms.employee.mapper.EmployeeMapper;
import com.mycom.vms.employee.model.EmployeeDto;
import com.mycom.vms.employee.validator.EmployeeRequestValidator;
import com.mycom.vms.employeedb.repo.service.EmployeeRepoService;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public abstract class AbstractEmployeeService implements EmployeeService {

    protected final EmployeeRepoService employeeRepoService;
    protected final EmployeeMapper employeeMapper;
    protected final EmployeeRequestValidator employeeRequestValidator;

    @Override
    public EmployeeDto createEmployeeDto (EmployeeDto employeeDto) {
        employeeRequestValidator.validateAddRequest(employeeDto);
        return addEmployeeDto(employeeDto);
    }

    @Override
    public EmployeeDto updateEmployeeDto(String employeeId, EmployeeDto employeeDto) {
        employeeRequestValidator.validateUpdateRequest(employeeDto);
        return updateDto(employeeId, employeeDto);
    }

    protected abstract EmployeeDto addEmployeeDto (EmployeeDto employeeDto);
    protected abstract EmployeeDto updateDto (String employeeId, EmployeeDto employeeDto);

}
