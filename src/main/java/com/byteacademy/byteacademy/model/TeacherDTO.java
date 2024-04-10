package com.byteacademy.byteacademy.model;

import com.byteacademy.byteacademy.model.auth.RoleDTO;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TeacherDTO {
    @Schema(hidden = true)
    private Long id;
    @NotBlank(message = "Name can not be empty or null")
    @Pattern(regexp = "^[A-Za-z]+$")
    private String name;
    @NotBlank(message = "Surname can not be empty or null")
    @Pattern(regexp = "^[A-Za-z]+$")
    private String surname;
    @NotBlank(message = "Username can not be empty or null")
    private String username;
    @NotBlank(message = "Password can not be empty or null")
    @Size(min = 8)
    @Pattern(regexp = "[A-Za-z0-9_.]+")
    private String password;
    @NotBlank(message = "Image can not be empty or null")
    private String imageUrl;
    @NotBlank(message = "Job can not be empty or null")
    private String job;
    @NotBlank(message = "About can not be empty or null")
    private String about;
    private List<Long> courseId;
    @NotNull(message = "Role can not be empty or null")
    private Set<RoleDTO> roles;
}
