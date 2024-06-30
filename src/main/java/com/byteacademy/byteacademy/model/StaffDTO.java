package com.byteacademy.byteacademy.model;

import com.byteacademy.byteacademy.model.auth.RoleDTO;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class StaffDTO {
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
    @NotBlank(message = "Username can not be empty or null")
    private String username;
    @NotBlank(message = "Password can not be empty or null")
    @Size(min = 8)
    @Pattern(regexp = "[A-Za-z0-9_.]+")
    private String password;
    @NotNull(message = "Role can not be empty or null")
    private Set<RoleDTO> roles;
}
