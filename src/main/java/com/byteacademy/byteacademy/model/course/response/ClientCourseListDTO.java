package com.byteacademy.byteacademy.model.course.response;

import com.byteacademy.byteacademy.model.category.CategoryDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClientCourseListDTO {
    private Long id;
    private String title;
    private String slug;
    private Integer duration;
    private CategoryDTO category;
}
