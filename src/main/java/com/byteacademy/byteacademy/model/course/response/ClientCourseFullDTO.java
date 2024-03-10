package com.byteacademy.byteacademy.model.course.response;

import com.byteacademy.byteacademy.model.category.CategoryDTO;
import com.byteacademy.byteacademy.model.teacher.response.MiniTeacherDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ClientCourseFullDTO {
    private Long id;
    private String title;
    private String slug;
    private String description;
    private Integer duration;
    private String format;
    private CategoryDTO category;
    private List<MiniTeacherDTO> teachers;

}
