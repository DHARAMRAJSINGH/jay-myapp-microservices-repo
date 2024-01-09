package com.mycom.vms.employeedb.repo.service;

import com.mycom.vms.employeedb.documents.Employee;
import com.mycom.vms.employeedb.repo.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Slf4j
@Service
public class EmployeeRepoServiceImpl implements EmployeeRepoService {

    private final EmployeeRepository employeeRepository;

    @Override
    public List<Employee> getEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee getEmployee(String employeeId) {
        return employeeRepository.findById(employeeId).orElseThrow();
    }

    @Override
    public Employee createEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public Employee updateEmployee(String employeeId, Employee employee) {
        Employee dbEmployee = employeeRepository.findById(employeeId).orElseThrow();
        employee.setEmployeeId(dbEmployee.getEmployeeId());
        return employeeRepository.save(employee);
    }

    @Override
    public void removeEmployee(String employeeId) {
        employeeRepository.findById(employeeId).orElseThrow();
        employeeRepository.deleteById(employeeId);
    }
}
