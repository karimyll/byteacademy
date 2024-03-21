package com.byteacademy.byteacademy.model.student.request;

import com.byteacademy.byteacademy.enums.GenderEnum;
import com.byteacademy.byteacademy.model.auth.RoleDTO;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RegisterStudentDTO {
    private String name;
    private String surname;
    private String fatherName;
    private LocalDate birthDate;
    @Enumerated(EnumType.STRING)
    private GenderEnum gender;
    private String username;
    private String password;
    private Set<RoleDTO> roles;
}
