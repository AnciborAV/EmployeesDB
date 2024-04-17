package org.example.mappers;

import org.example.controllers.OfficeDto;
import org.example.models.Office;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface OfficeMapper {

    OfficeDto toDto(Office office);

    @Mapping(target = "version", ignore = true)
    @Mapping(target = "created", ignore = true)
    Office toEntity(OfficeDto officeDto);
}
