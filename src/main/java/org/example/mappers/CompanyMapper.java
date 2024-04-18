package org.example.mappers;

import org.example.controllers.CompanyDto;
import org.example.models.Company;
import org.mapstruct.Mapper;

@Mapper
public interface CompanyMapper {

    CompanyDto toDto(Company company);

    Company toEntity(CompanyDto companyDto);
}
