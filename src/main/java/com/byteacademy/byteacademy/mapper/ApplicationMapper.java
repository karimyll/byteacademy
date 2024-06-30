package com.byteacademy.byteacademy.mapper;

import com.byteacademy.byteacademy.dao.entity.Application;
import com.byteacademy.byteacademy.model.ApplicationDTO;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface ApplicationMapper {

    ApplicationDTO mapToDTO(Application applicationEntity);

    Application mapToEntity(ApplicationDTO applicationDTO);

    Application mapUpdateDtoToEntity(@MappingTarget Application applicationEntity, ApplicationDTO applicationDTO);

}
