package com.byteacademy.byteacademy.model.teacher.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MiniTeacherDTO {
    private Long id;
    private String name;
    private String surname;
    private String username;
    private String imageUrl;
    private String job;
}
