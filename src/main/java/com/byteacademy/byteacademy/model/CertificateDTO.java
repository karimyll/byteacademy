package com.byteacademy.byteacademy.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CertificateDTO {
    @Schema(hidden = true)
    private Long id;
    @NotNull(message = "Enrollment id can not be empty or null")
    private Long enrollmentId;
    @NotNull(message = "Point can not be empty or null")
    @Min(value = 0)
    @Max(value = 100)
    private Double point;
    @NotBlank(message = "Verification NO can not be empty or null")
    private String verificationNo;
    @Schema(hidden = true)
    private EnrollmentDTO enrollment;
}
