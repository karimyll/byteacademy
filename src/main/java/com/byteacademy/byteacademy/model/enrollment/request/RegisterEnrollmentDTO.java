package com.byteacademy.byteacademy.model.enrollment.request;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegisterEnrollmentDTO {
    private Long courseId;
    private Long studentId;
    private Long teacherId;
    private Long groupId;
    private LocalDate startDate;
    @JsonIgnore
    private boolean cancelled;
}
