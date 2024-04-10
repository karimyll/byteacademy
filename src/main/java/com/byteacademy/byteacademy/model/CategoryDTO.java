package com.byteacademy.byteacademy.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CategoryDTO {
    @Schema(hidden = true)
    private Long id;
    @NotBlank(message = "Title can not be empty or null")
    private String title;
    @NotBlank(message = "Slug can not be empty or null")
    private String slug;

}
