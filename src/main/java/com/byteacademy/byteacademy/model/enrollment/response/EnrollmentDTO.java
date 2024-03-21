package com.byteacademy.byteacademy.model.enrollment.response;

import com.byteacademy.byteacademy.model.course.response.TitleCourseDTO;
import com.byteacademy.byteacademy.model.group.response.ResponseGroupDTO;
import com.byteacademy.byteacademy.model.student.response.MiniStudentDTO;
import com.byteacademy.byteacademy.model.teacher.response.MiniTeacherDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EnrollmentDTO {
    private Long id;
    private TitleCourseDTO course;
    private MiniStudentDTO student;
    private MiniTeacherDTO teacher;
    private ResponseGroupDTO group;
    private LocalDate startDate;
    private LocalDate endDate;
    private boolean cancelled;
}
