package com.byteacademy.byteacademy.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class GroupDTO {
    @Schema(hidden = true)
    private Long id;
    @NotNull(message = "Number id can not be empty or null")
    private Long number;
    @NotBlank(message = "Enrollment id can not be empty or null")
    private String name;
    @Schema(hidden = true)
    private LocalDate createdDate;
}
