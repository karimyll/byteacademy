package com.byteacademy.byteacademy.mapper;

import com.byteacademy.byteacademy.dao.entity.CourseEntity;
import com.byteacademy.byteacademy.dao.entity.TeacherEntity;
import com.byteacademy.byteacademy.model.RequestUpdateTeacherDTO;
import com.byteacademy.byteacademy.model.TeacherDTO;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface TeacherMapper {

    TeacherEntity mapToEntity(TeacherDTO teacherDTO);
    TeacherEntity mapUpdateToEntity(@MappingTarget TeacherEntity teacher, RequestUpdateTeacherDTO updateTeacherDTO);

    @Mapping(target = "password", ignore = true)
    @Mapping(target = "courseId", ignore = true)
    @Mapping(target = "roles", ignore = true)
    TeacherDTO mapToResponse(TeacherEntity teacher);


    @AfterMapping
    default void mapCourses(TeacherDTO teacherDTO, @MappingTarget TeacherEntity teacherEntity) {
        if (teacherDTO.getCourseId() != null) {
            List<CourseEntity> courseEntities = teacherDTO.getCourseId().stream()
                    .map(courseId -> {
                        CourseEntity courseEntity = new CourseEntity();
                        courseEntity.setId(courseId);
                        return courseEntity;
                    })
                    .toList();

            teacherEntity.setCourse(courseEntities);
        }
    }

    @AfterMapping
    default void mapCoursesForUpdate(RequestUpdateTeacherDTO teacherDTO, @MappingTarget TeacherEntity teacherEntity) {
        if (teacherDTO.getCourseId() != null) {
            List<CourseEntity> courseEntities = teacherDTO.getCourseId().stream()
                    .map(courseId -> {
                        CourseEntity courseEntity = new CourseEntity();
                        courseEntity.setId(courseId);
                        return courseEntity;
                    })
                    .toList();

            teacherEntity.setCourse(courseEntities);
        }
    }

}
