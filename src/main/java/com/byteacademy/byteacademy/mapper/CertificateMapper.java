package com.byteacademy.byteacademy.mapper;

import com.byteacademy.byteacademy.dao.entity.*;
import com.byteacademy.byteacademy.model.*;
import org.mapstruct.*;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface CertificateMapper {

    @Mapping(target = "enrollment", source = "enrollmentId", qualifiedByName = "toEnrollmentEntity")
    Certificate mapToEntity(CertificateDTO certificateDTO);

    @Mapping(target = "enrollment" ,ignore = true)
    CertificateDTO mapToResponse(Certificate certificateEntity);

    Certificate mapToUpdateEntity(@MappingTarget Certificate certificateEntity, CertificateDTO certificateDTO);

    CertificateDTO mapToFullResponse(Certificate certificateEntity);

    default StudentDTO studentEntityToStudentDTO(Student studentEntity) {
        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setName( studentEntity.getName() );
        studentDTO.setSurname( studentEntity.getSurname() );
        return studentDTO;
    }

    default CourseDTO courseEntityToCourseDTO(Course courseEntity) {
        CourseDTO courseDTO = new CourseDTO();
        courseDTO.setTitle( courseEntity.getTitle() );
        return courseDTO;
    }

    default TeacherDTO teacherEntityToTeacherDTO(Teacher teacherEntity) {
        TeacherDTO teacherDTO = new TeacherDTO();
        teacherDTO.setName( teacherEntity.getName() );
        teacherDTO.setSurname( teacherEntity.getSurname() );
        return teacherDTO;
    }

    default GroupDTO groupEntityToGroupDTO(Group groupEntity) {
        return new GroupDTO();
    }


    @Named("toEnrollmentEntity")
    default Enrollment toEnrollmentEntity(Long enrollmentId) {
        if (enrollmentId == null) {
            return null;
        }
        Enrollment enrollmentEntity = new Enrollment();
        enrollmentEntity.setId(enrollmentId);
        return enrollmentEntity;
    }
}
