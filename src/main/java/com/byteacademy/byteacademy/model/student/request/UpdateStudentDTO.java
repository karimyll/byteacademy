package com.byteacademy.byteacademy.model.student.request;

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
public class UpdateStudentDTO {
    private String name;
    private String surname;
    private String fatherName;
    private LocalDate birthDate;
    @Enumerated(EnumType.STRING)
    private GenderEnum gender;
}
