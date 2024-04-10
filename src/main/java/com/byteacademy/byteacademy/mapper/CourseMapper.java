package com.byteacademy.byteacademy.mapper;

import com.byteacademy.byteacademy.dao.entity.CourseEntity;
import com.byteacademy.byteacademy.model.CourseDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface CourseMapper {
    @Mapping(target = "teacherId", ignore = true)
    CourseDTO mapToFullDTO(CourseEntity course);

    @Mapping(target = "teacherId", ignore = true)
    @Mapping(target = "description", ignore = true)
    @Mapping(target = "format", ignore = true)
    CourseDTO mapToListDTO(CourseEntity course);

    CourseEntity mapToEntity(CourseDTO courseDTO);
    CourseEntity mapUpdateDtoToEntity(@MappingTarget CourseEntity courseEntity, CourseDTO clientCourseFullDTO);
}
