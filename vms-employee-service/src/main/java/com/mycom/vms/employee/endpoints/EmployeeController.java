package com.mycom.vms.employee.endpoints;

import com.mycom.vms.employee.model.EmployeeDto;
import com.mycom.vms.employee.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(
        "http://localhost:4200/"
)
@RequestMapping("/employees")
@RequiredArgsConstructor
@RestController
public class EmployeeController {

    private final EmployeeService employeeService;

    @GetMapping
    public List<EmployeeDto> getEmployeeDtoList () {
        return employeeService.getEmployeeDtoList();
    }

    @GetMapping("{employeeId}")
    public EmployeeDto getEmployeeDto (@PathVariable String employeeId) {
        return employeeService.getEmployeeDto(employeeId);
    }

    @PostMapping("")
    public EmployeeDto createEmployeeDto (@RequestBody EmployeeDto employeeDto) {
        return employeeService.createEmployeeDto(employeeDto);
    }

    @PutMapping("{employeeId}")
    public EmployeeDto updateEmployeeDto (@PathVariable String employeeId, @RequestBody EmployeeDto employeeDto) {
        return employeeService.updateEmployeeDto(employeeId, employeeDto);
    }

    @DeleteMapping("{employeeId}")
    public void removeEmployeeDto (@PathVariable String employeeId) {
        employeeService.removeEmployeeDto(employeeId);
    }
}
