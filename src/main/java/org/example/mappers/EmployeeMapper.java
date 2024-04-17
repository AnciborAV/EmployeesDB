package org.example.mappers;

import org.example.controllers.EmployeeDto;
import org.example.models.Employee;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface EmployeeMapper {

    EmployeeDto toEmployeeDto(Employee employee);

    @Mapping(target = "version", ignore = true)
    @Mapping(target = "creates", ignore = true)
    Employee toEmployee(EmployeeDto employeeDto);
}
