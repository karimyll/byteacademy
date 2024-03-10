package com.byteacademy.byteacademy.model.teacher.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateTeacherDTO {
    private String name;
    private String surname;
    private String imageUrl;
    private String job;
    private String about;
    private List<Long> courseId;
}
