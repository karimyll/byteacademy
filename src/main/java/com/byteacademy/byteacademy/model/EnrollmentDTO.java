package com.byteacademy.byteacademy.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.NumberFormat;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class EnrollmentDTO {
    @Schema(hidden = true)
    private Long id;
    @NotNull(message = "Course id can not be empty or null")
    @NumberFormat
    private Long courseId;
    @NotNull(message = "Student id can not be empty or null")
    @NumberFormat
    private Long studentId;
    @NotNull(message = "Teacher id can not be empty or null")
    @NumberFormat
    private Long teacherId;
    @NumberFormat
    private Long groupId;
    private LocalDate startDate;
    @Schema(hidden = true)
    private boolean cancelled;
    @Schema(hidden = true)
    private StudentDTO student;
    @Schema(hidden = true)
    private CourseDTO course;
    @Schema(hidden = true)
    private TeacherDTO teacher;
    @Schema(hidden = true)
    private GroupDTO group;
    @Schema(hidden = true)
    private LocalDate endDate;
}
