package com.webetapi.api.repository;

import com.webetapi.api.model.Employee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Long>{

}
