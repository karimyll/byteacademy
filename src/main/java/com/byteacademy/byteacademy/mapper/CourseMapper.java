package com.byteacademy.byteacademy.mapper;

import com.byteacademy.byteacademy.dao.entity.CourseEntity;
import com.byteacademy.byteacademy.model.course.request.CourseDTO;
import com.byteacademy.byteacademy.model.course.response.ClientCourseFullDTO;
import com.byteacademy.byteacademy.model.course.response.ClientCourseListDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface CourseMapper {
    ClientCourseFullDTO mapToFullDTO(CourseEntity course);
    ClientCourseListDTO mapToListDTO(CourseEntity course);
    CourseEntity mapToEntity(CourseDTO courseDTO);
    CourseEntity mapUpdateDtoToEntity(@MappingTarget CourseEntity courseEntity, CourseDTO clientCourseFullDTO);
}
