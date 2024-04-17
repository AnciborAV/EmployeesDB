package org.example.repositories;

import org.example.models.Office;
import org.springframework.data.repository.CrudRepository;
import org.springframework.lang.NonNull;

import java.util.List;
import java.util.Optional;

public interface OfficeRepository
        extends CrudRepository<Office, Long> {

    @NonNull
    @Override
    List<Office> findAll();

    @NonNull
    @Override
    Optional<Office> findById(@NonNull Long id);

    @NonNull
    @Override
    <S extends Office> S save(@NonNull S s);
}
