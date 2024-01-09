package com.mycom.vms.employee.service;

import com.mycom.vms.employee.mapper.EmployeeMapper;
import com.mycom.vms.employee.model.EmployeeDto;
import com.mycom.vms.employee.validator.EmployeeRequestValidator;
import com.mycom.vms.employeedb.repo.service.EmployeeRepoService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl extends AbstractEmployeeService {

    public EmployeeServiceImpl (EmployeeRepoService employeeRepoService,
                                EmployeeMapper employeeMapper, EmployeeRequestValidator employeeRequestValidator) {
        super(employeeRepoService, employeeMapper, employeeRequestValidator);
    }

    @Override
    public List<EmployeeDto> getEmployeeDtoList() {
        return employeeRepoService.getEmployees().stream().
                map(employeeMapper::toEmployeeDto).collect(Collectors.toList());
    }

    @Override
    public EmployeeDto getEmployeeDto(String employeeId) {
        return employeeMapper.toEmployeeDto(employeeRepoService.getEmployee(employeeId));
    }

    @Override
    protected EmployeeDto addEmployeeDto(EmployeeDto employeeDto) {
        return employeeMapper.toEmployeeDto(
                employeeRepoService.createEmployee(employeeMapper.toEmployee(employeeDto)));
    }

    @Override
    public EmployeeDto updateDto (String employeeId, EmployeeDto employeeDto) {
        return employeeMapper.toEmployeeDto(
                employeeRepoService.updateEmployee(employeeId, employeeMapper.toEmployee(employeeDto)));
    }

    @Override
    public void removeEmployeeDto(String employeeId) {
        employeeRepoService.removeEmployee(employeeId);
    }
}
