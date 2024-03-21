package com.byteacademy.byteacademy.model.enrollment.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateEnrollmentDTO {
    private Long courseId;
    private Long teacherId;
    private Long groupId;
    private LocalDate startDate;
    private LocalDate endDate;
    private boolean cancelled;
}
