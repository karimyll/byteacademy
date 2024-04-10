package com.byteacademy.byteacademy.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RequestUpdateEnrollmentDTO {
    private Long courseId;
    private Long teacherId;
    private Long groupId;
    private LocalDate startDate;
    private LocalDate endDate;
    private boolean cancelled;
}
