package com.byteacademy.byteacademy.mapper;

import com.byteacademy.byteacademy.dao.entity.Course;
import com.byteacademy.byteacademy.dao.entity.Teacher;
import com.byteacademy.byteacademy.model.RequestUpdateTeacherDTO;
import com.byteacademy.byteacademy.model.TeacherDTO;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface TeacherMapper {

    Teacher mapToEntity(TeacherDTO teacherDTO);
    Teacher mapUpdateToEntity(@MappingTarget Teacher teacher, RequestUpdateTeacherDTO updateTeacherDTO);

    @Mapping(target = "password", ignore = true)
    @Mapping(target = "courseId", ignore = true)
    @Mapping(target = "roles", ignore = true)
    TeacherDTO mapToResponse(Teacher teacher);


    @AfterMapping
    default void mapCourses(TeacherDTO teacherDTO, @MappingTarget Teacher teacherEntity) {
        if (teacherDTO.getCourseId() != null) {
            List<Course> courseEntities = teacherDTO.getCourseId().stream()
                    .map(courseId -> {
                        Course courseEntity = new Course();
                        courseEntity.setId(courseId);
                        return courseEntity;
                    })
                    .toList();

            teacherEntity.setCourse(courseEntities);
        }
    }

    @AfterMapping
    default void mapCoursesForUpdate(RequestUpdateTeacherDTO teacherDTO, @MappingTarget Teacher teacherEntity) {
        if (teacherDTO.getCourseId() != null) {
            List<Course> courseEntities = teacherDTO.getCourseId().stream()
                    .map(courseId -> {
                        Course courseEntity = new Course();
                        courseEntity.setId(courseId);
                        return courseEntity;
                    })
                    .toList();

            teacherEntity.setCourse(courseEntities);
        }
    }

}
