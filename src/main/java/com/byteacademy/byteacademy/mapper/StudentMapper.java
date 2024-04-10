package com.byteacademy.byteacademy.mapper;

import com.byteacademy.byteacademy.dao.entity.StudentEntity;
import com.byteacademy.byteacademy.model.RequestUpdateStudentDTO;
import com.byteacademy.byteacademy.model.StudentDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface StudentMapper {
    @Mapping(target = "password", ignore = true)
    @Mapping(target = "roles", ignore = true)
    StudentDTO mapToResponseDTO(StudentEntity student);
    StudentEntity mapToEntity(StudentDTO registerStudentDTO);
    StudentEntity mapToUpdateEntity(@MappingTarget StudentEntity student, RequestUpdateStudentDTO updateStudentDTO);
}
