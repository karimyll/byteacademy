package com.byteacademy.byteacademy.mapper;

import com.byteacademy.byteacademy.dao.entity.*;
import com.byteacademy.byteacademy.model.*;
import org.mapstruct.*;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface EnrollmentMapper {

    @Mapping(target = "course", source = "courseId", qualifiedByName = "toCourseEntity")
    @Mapping(target = "student", source = "studentId", qualifiedByName = "toStudentEntity")
    @Mapping(target = "teacher", source = "teacherId", qualifiedByName = "toTeacherEntity")
    @Mapping(target = "group", source = "groupId", qualifiedByName = "toGroupEntity")
    Enrollment mapToEntity(EnrollmentDTO enrollmentDTO);

    Enrollment mapToUpdateDTO(@MappingTarget Enrollment enrollmentEntity,
                              RequestUpdateEnrollmentDTO updateEnrollmentDTO);

    @Mapping(target = "student" , ignore = true)
    @Mapping(target = "course", ignore = true)
    @Mapping(target = "teacher", ignore = true)
    @Mapping(target = "group", ignore = true)
    EnrollmentDTO mapToResponseDTO(Enrollment enrollmentEntity);
    EnrollmentDTO mapToFullResponseDTO(Enrollment enrollmentEntity);


    @Named("toCourseEntity")
    default Course toCourseEntity(Long courseId) {
        if (courseId == null) {
            return null;
        }
        Course courseEntity = new Course();
        courseEntity.setId(courseId);
        return courseEntity;
    }

    @Named("toGroupEntity")
    default Group toGroupEntity(Long groupId) {
        if (groupId == null) {
            return null;
        }
        Group group = new Group();
        group.setId(groupId);
        return group;
    }

    @Named("toStudentEntity")
    default Student toStudentEntity(Long studentId) {
        if (studentId == null) {
            return null;
        }
        Student student = new Student();
        student.setId(studentId);
        return student;
    }

    @Named("toTeacherEntity")
    default Teacher toTeacherEntity(Long teacherId) {
        if (teacherId == null) {
            return null;
        }
        Teacher teacher = new Teacher();
        teacher.setId(teacherId);
        return teacher;
    }
}
