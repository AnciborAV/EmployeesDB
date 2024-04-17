package org.example.mappers;

import org.example.controllers.EmployeeDto;
import org.example.models.Employee;
import org.mapstruct.Mapper;

@Mapper
public interface EmployeeMapper {

    EmployeeDto toEmployeeDto(Employee employee);

    Employee toEmployee(EmployeeDto employeeDto);
}
