package com.byteacademy.byteacademy.mapper;

import com.byteacademy.byteacademy.dao.entity.*;
import com.byteacademy.byteacademy.model.enrollment.request.RegisterEnrollmentDTO;
import com.byteacademy.byteacademy.model.enrollment.request.UpdateEnrollmentDTO;
import com.byteacademy.byteacademy.model.enrollment.response.EnrollmentDTO;
import org.mapstruct.*;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface EnrollmentMapper {
    @Mapping(target = "course", source = "courseId", qualifiedByName = "toCourseEntity")
    @Mapping(target = "student", source = "studentId", qualifiedByName = "toStudentEntity")
    @Mapping(target = "teacher", source = "teacherId", qualifiedByName = "toTeacherEntity")
    @Mapping(target = "group", source = "groupId", qualifiedByName = "toGroupEntity")
    EnrollmentEntity mapToEntity(RegisterEnrollmentDTO enrollmentDTO);
    EnrollmentDTO mapToDTO(EnrollmentEntity enrollmentEntity);
    EnrollmentEntity mapToUpdateDTO(@MappingTarget EnrollmentEntity enrollmentEntity,
                                    UpdateEnrollmentDTO updateEnrollmentDTO);


    @Named("toCourseEntity")
    default CourseEntity toCourseEntity(Long courseId) {
        if (courseId == null) {
            return null;
        }
        CourseEntity courseEntity = new CourseEntity();
        courseEntity.setId(courseId);
        return courseEntity;
    }

    @Named("toGroupEntity")
    default GroupEntity toGroupEntity(Long groupId) {
        if (groupId == null) {
            return null;
        }
        GroupEntity group = new GroupEntity();
        group.setId(groupId);
        return group;
    }

    @Named("toStudentEntity")
    default StudentEntity toStudentEntity(Long studentId) {
        if (studentId == null) {
            return null;
        }
        StudentEntity student = new StudentEntity();
        student.setId(studentId);
        return student;
    }

    @Named("toTeacherEntity")
    default TeacherEntity toTeacherEntity(Long teacherId) {
        if (teacherId == null) {
            return null;
        }
        TeacherEntity teacher = new TeacherEntity();
        teacher.setId(teacherId);
        return teacher;
    }
}
