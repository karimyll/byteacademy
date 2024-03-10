package com.byteacademy.byteacademy.model.course.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CourseDTO {
    private String title;
    private String slug;
    private String description;
    private Integer duration;
    private String format;
    private List<Long> teacherId;
}
