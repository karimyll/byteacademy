package com.byteacademy.byteacademy.mapper;

import com.byteacademy.byteacademy.dao.entity.CourseEntity;
import com.byteacademy.byteacademy.dao.entity.TeacherEntity;
import com.byteacademy.byteacademy.model.teacher.request.RegisterTeacherDTO;
import com.byteacademy.byteacademy.model.teacher.request.UpdateTeacherDTO;
import com.byteacademy.byteacademy.model.teacher.response.DetailedTeacherDTO;
import com.byteacademy.byteacademy.model.teacher.response.MiniTeacherDTO;
import org.mapstruct.*;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface TeacherMapper {
    MiniTeacherDTO mapToMiniDTO(TeacherEntity teacher);
    DetailedTeacherDTO mapToDetailedDTO(TeacherEntity teacher);
    TeacherEntity mapToEntity(RegisterTeacherDTO registerTeacherDTO);
    TeacherEntity mapUpdateToEntity(@MappingTarget TeacherEntity teacher, UpdateTeacherDTO updateTeacherDTO);

    @AfterMapping
    default void mapCourses(RegisterTeacherDTO teacherDTO, @MappingTarget TeacherEntity teacherEntity) {
        if (teacherDTO.getCourseId() != null) {
            List<CourseEntity> courseEntities = teacherDTO.getCourseId().stream()
                    .map(courseId -> {
                        CourseEntity courseEntity = new CourseEntity();
                        courseEntity.setId(courseId);
                        return courseEntity;
                    })
                    .collect(Collectors.toList());

            teacherEntity.setCourse(courseEntities);
        }
    }

}
