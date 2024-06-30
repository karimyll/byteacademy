package com.byteacademy.byteacademy.mapper;

import com.byteacademy.byteacademy.dao.entity.Staff;
import com.byteacademy.byteacademy.model.StaffDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface StaffMapper {

    @Mapping(target = "password", ignore = true)
    @Mapping(target = "roles", ignore = true)
    StaffDTO mapToDTO(Staff staffEntity);

    Staff mapToEntity(StaffDTO staffDTO);
    Staff mapToUpdateEntity(@MappingTarget Staff staffEntity, StaffDTO staffDTO);
}
