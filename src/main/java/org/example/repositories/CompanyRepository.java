package org.example.repositories;

import org.example.models.Company;
import org.springframework.data.repository.CrudRepository;
import org.springframework.lang.NonNull;

import java.util.List;
import java.util.Optional;

public interface CompanyRepository
        extends CrudRepository<Company, Long> {

    @NonNull
    @Override
    List<Company> findAll();

    @NonNull
    @Override
    Optional<Company> findById(@NonNull Long id);

    @NonNull
    @Override
    <S extends Company> S save(@NonNull S entity);
}
