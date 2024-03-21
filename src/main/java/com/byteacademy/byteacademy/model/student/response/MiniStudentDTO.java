package com.byteacademy.byteacademy.model.student.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MiniStudentDTO {
    private Long id;
    private String name;
    private String surname;
}
