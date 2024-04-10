package com.byteacademy.byteacademy.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CourseDTO {
    @Schema(hidden = true)
    private Long id;
    @NotBlank(message = "Title can not be empty or null")
    private String title;
    @NotBlank(message = "Slug can not be empty or null")
    private String slug;
    @NotBlank(message = "Description can not be empty or null")
    private String description;
    @NotNull(message = "Duration can not be empty or null")
    private Integer duration;
    @NotBlank(message = "Format can not be empty or null")
    private String format;
    private List<Long> teacherId;
}
