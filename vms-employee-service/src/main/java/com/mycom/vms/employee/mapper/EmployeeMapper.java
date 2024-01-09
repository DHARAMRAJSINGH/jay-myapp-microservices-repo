package com.mycom.vms.employee.mapper;

import com.mycom.vms.employee.model.EmployeeDto;
import com.mycom.vms.employeedb.documents.Employee;
import org.springframework.stereotype.Component;

@Component
public class EmployeeMapper {

    public EmployeeDto toEmployeeDto (Employee employee) {
        return EmployeeDto.builder().employeeId(employee.getEmployeeId())
                .firstName(employee.getFirstName()).lastName(employee.getLastName())
                .emailId(employee.getEmailId())
                .build();
    }

    public Employee toEmployee (EmployeeDto dto) {
        return Employee.builder().employeeId(dto.getEmployeeId())
                .firstName(dto.getFirstName()).lastName(dto.getLastName())
                .emailId(dto.getEmailId())
                .build();
    }
}
