package com.byteacademy.byteacademy.model.student.response;

import com.byteacademy.byteacademy.enums.GenderEnum;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FullStudentDTO {
    private Long id;
    private String name;
    private String surname;
    private String fatherName;
    private LocalDate birthDate;
    @Enumerated(EnumType.STRING)
    private GenderEnum gender;
    private String username;
}
