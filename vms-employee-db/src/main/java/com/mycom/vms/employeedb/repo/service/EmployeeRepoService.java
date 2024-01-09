package com.mycom.vms.employeedb.repo.service;

import com.mycom.vms.employeedb.documents.Employee;

import java.util.List;

public interface EmployeeRepoService {

    List<Employee> getEmployees ();
    Employee getEmployee (String employeeId);
    Employee createEmployee (Employee employee);
    Employee updateEmployee (String employeeId, Employee employee);
    void removeEmployee (String employeeId);
}
