package com.byteacademy.byteacademy.model.teacher.response;

import com.byteacademy.byteacademy.model.course.response.ClientCourseListDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DetailedTeacherDTO {
    private Long id;
    private String name;
    private String surname;
    private String username;
    private String imageUrl;
    private String job;
    private String about;
    private List<ClientCourseListDTO> course;
}
