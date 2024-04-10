package com.byteacademy.byteacademy.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RequestUpdateTeacherDTO {
    private String name;
    private String surname;
    private String imageUrl;
    private String job;
    private String about;
    private List<Long> courseId;
}
