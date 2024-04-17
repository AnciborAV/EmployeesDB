package org.example.repositories;

import org.example.models.Employee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.lang.NonNull;

import java.util.List;
import java.util.Optional;

public interface EmployeeRepository
        extends CrudRepository<Employee, Long> {

    @NonNull
    @Override
    List<Employee> findAll();

    @NonNull
    @Override
    Optional<Employee> findById(@NonNull Long id);

    @NonNull
    @Override
    <S extends Employee> S save(@NonNull S employee);
}
