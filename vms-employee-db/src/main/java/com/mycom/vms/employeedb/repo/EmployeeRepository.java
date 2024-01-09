package com.mycom.vms.employeedb.repo;

import com.mycom.vms.employeedb.documents.Employee;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface EmployeeRepository extends MongoRepository<Employee, String> {
}
