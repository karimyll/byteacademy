package com.byteacademy.byteacademy.model.category;

import com.byteacademy.byteacademy.model.course.response.ClientCourseListDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CategoryDTO {
    private String title;
}
