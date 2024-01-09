package com.mycom.vms.employee.service;

import com.mycom.vms.employee.model.EmployeeDto;

import java.util.List;

public interface EmployeeService {

    List<EmployeeDto> getEmployeeDtoList ();
    EmployeeDto getEmployeeDto (String employeeId);
    EmployeeDto createEmployeeDto (EmployeeDto employeeDto);
    EmployeeDto updateEmployeeDto (String employeeId, EmployeeDto employeeDto);
    void removeEmployeeDto (String employeeId);

}
