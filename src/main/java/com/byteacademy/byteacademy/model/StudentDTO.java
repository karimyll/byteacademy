package com.byteacademy.byteacademy.model;

import com.byteacademy.byteacademy.enums.GenderEnum;
import com.byteacademy.byteacademy.model.auth.RoleDTO;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class StudentDTO {
    @Schema(hidden = true)
    private Long id;
    @NotBlank(message = "Name can not be empty or null")
    @Pattern(regexp = "^[A-Za-z]+$")
    private String name;
    @NotBlank(message = "Surname can not be empty or null")
    @Pattern(regexp = "^[A-Za-z]+$")
    private String surname;
    @NotBlank(message = "Father name can not be empty or null")
    @Pattern(regexp = "^[A-Za-z]+$")
    private String fatherName;
    @JsonFormat(pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @PastOrPresent(message = "Birthday can not future date")
    private LocalDate birthDate;
    @Enumerated(EnumType.STRING)
    private GenderEnum gender;
    @NotBlank(message = "Username can not be empty or null")
    private String username;
    @NotBlank(message = "Password can not be empty or null")
    @Size(min = 8)
    @Pattern(regexp = "[A-Za-z0-9_.]+")
    private String password;
    @NotNull(message = "Role can not be empty or null")
    private Set<RoleDTO> roles;
}
