package com.byteacademy.byteacademy.mapper;

import com.byteacademy.byteacademy.dao.entity.Group;
import com.byteacademy.byteacademy.model.GroupDTO;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface GroupMapper {
    GroupDTO mapToDTO(Group group);
    Group mapToEntity(GroupDTO registerGroupDTO);
    Group mapToUpdateEntity(@MappingTarget Group group, GroupDTO registerGroupDTO);
}
