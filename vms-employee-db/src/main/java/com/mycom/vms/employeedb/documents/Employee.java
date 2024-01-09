package com.mycom.vms.employeedb.documents;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;

@Builder
@Data
public class Employee {

    @Id
    private String employeeId;
    private String firstName;
    private String lastName;
    private String emailId;

}
