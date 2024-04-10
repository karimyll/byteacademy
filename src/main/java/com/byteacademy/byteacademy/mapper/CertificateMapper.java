package com.byteacademy.byteacademy.mapper;

import com.byteacademy.byteacademy.dao.entity.*;
import com.byteacademy.byteacademy.model.*;
import org.mapstruct.*;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface CertificateMapper {

    @Mapping(target = "enrollment", source = "enrollmentId", qualifiedByName = "toEnrollmentEntity")
    CertificateEntity mapToEntity(CertificateDTO certificateDTO);

    @Mapping(target = "enrollment" ,ignore = true)
    CertificateDTO mapToResponse(CertificateEntity certificateEntity);

    CertificateEntity mapToUpdateEntity(@MappingTarget CertificateEntity certificateEntity, CertificateDTO certificateDTO);

    CertificateDTO mapToFullResponse(CertificateEntity certificateEntity);

    default StudentDTO studentEntityToStudentDTO(StudentEntity studentEntity) {
        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setName( studentEntity.getName() );
        studentDTO.setSurname( studentEntity.getSurname() );
        return studentDTO;
    }

    default CourseDTO courseEntityToCourseDTO(CourseEntity courseEntity) {
        CourseDTO courseDTO = new CourseDTO();
        courseDTO.setTitle( courseEntity.getTitle() );
        return courseDTO;
    }

    default TeacherDTO teacherEntityToTeacherDTO(TeacherEntity teacherEntity) {
        TeacherDTO teacherDTO = new TeacherDTO();
        teacherDTO.setName( teacherEntity.getName() );
        teacherDTO.setSurname( teacherEntity.getSurname() );
        return teacherDTO;
    }

    default GroupDTO groupEntityToGroupDTO(GroupEntity groupEntity) {
        return new GroupDTO();
    }


    @Named("toEnrollmentEntity")
    default EnrollmentEntity toEnrollmentEntity(Long enrollmentId) {
        if (enrollmentId == null) {
            return null;
        }
        EnrollmentEntity enrollmentEntity = new EnrollmentEntity();
        enrollmentEntity.setId(enrollmentId);
        return enrollmentEntity;
    }
}
