package com.byteacademy.byteacademy.mapper;

import com.byteacademy.byteacademy.dao.entity.GroupEntity;
import com.byteacademy.byteacademy.model.GroupDTO;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface GroupMapper {
    GroupDTO mapToDTO(GroupEntity group);
    GroupEntity mapToEntity(GroupDTO registerGroupDTO);
    GroupEntity mapToUpdateEntity(@MappingTarget GroupEntity group, GroupDTO registerGroupDTO);
}
