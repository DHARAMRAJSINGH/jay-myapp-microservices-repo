package com.mycom.vms.employee.model;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class EmployeeDto {

    private String employeeId;
    private String firstName;
    private String lastName;
    private String emailId;
}
