package com.byteacademy.byteacademy.model;

import com.byteacademy.byteacademy.enums.StatusEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApplicationDTO {
    @Schema(hidden = true)
    private Long id;
    @NotBlank(message = "Full Name must not be null")
    private String fullName;
    @NotBlank(message = "Email must not be null")
    @Email
    private String email;
    @NotBlank(message = "Phone number must not be null")
    @Pattern(regexp = "^\\+994\\d+$")
    @Length(max = 13)
    @Length(min = 13)
    private String phoneNumber;
    @NotBlank(message = "Course must not be null")
    private String courseName;
    @Schema(hidden = true)
    private StatusEnum status;
}
