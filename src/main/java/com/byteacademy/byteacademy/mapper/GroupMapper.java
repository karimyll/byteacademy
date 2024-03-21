package com.byteacademy.byteacademy.mapper;

import com.byteacademy.byteacademy.dao.entity.GroupEntity;
import com.byteacademy.byteacademy.model.group.request.RegisterGroupDTO;
import com.byteacademy.byteacademy.model.group.response.ResponseGroupDTO;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface GroupMapper {
    ResponseGroupDTO mapToDTO(GroupEntity group);
    GroupEntity mapToEntity(RegisterGroupDTO registerGroupDTO);
    GroupEntity mapToUpdateEntity(@MappingTarget GroupEntity group, RegisterGroupDTO registerGroupDTO);
}
