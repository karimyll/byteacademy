package com.byteacademy.byteacademy.mapper;

import com.byteacademy.byteacademy.dao.entity.StudentEntity;
import com.byteacademy.byteacademy.model.student.request.RegisterStudentDTO;
import com.byteacademy.byteacademy.model.student.request.UpdateStudentDTO;
import com.byteacademy.byteacademy.model.student.response.FullStudentDTO;
import com.byteacademy.byteacademy.model.student.response.MiniStudentDTO;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface StudentMapper {
    FullStudentDTO mapToFullDTO(StudentEntity student);
    MiniStudentDTO mapToMiniDTO(StudentEntity student);
    StudentEntity mapToEntity(RegisterStudentDTO registerStudentDTO);
    StudentEntity mapToUpdateEntity(@MappingTarget StudentEntity student, UpdateStudentDTO updateStudentDTO);
}
