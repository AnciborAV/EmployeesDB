package org.example.mappers;

import org.example.controllers.OfficeDto;
import org.example.models.Office;
import org.mapstruct.Mapper;

@Mapper
public interface OfficeMapper {

    OfficeDto toDto(Office office);

    Office toEntity(OfficeDto officeDto);
}
