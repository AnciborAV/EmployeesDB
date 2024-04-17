package org.example.mappers;

import org.example.controllers.CompanyDto;
import org.example.models.Company;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface CompanyMapper {

    CompanyDto toDto(Company company);

    @Mapping(target = "version", ignore = true)
    @Mapping(target = "created", ignore = true)
    Company toEntity(CompanyDto companyDto);
}
