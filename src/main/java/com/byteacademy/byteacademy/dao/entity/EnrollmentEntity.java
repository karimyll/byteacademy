package com.byteacademy.byteacademy.dao.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "enrollment")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EnrollmentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "course_id")
    private CourseEntity course;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private StudentEntity student;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "teacher_id")
    private TeacherEntity teacher;

    @ManyToOne
    @JoinColumn(name = "group_id")
    private GroupEntity group;

    @Column(name = "start_date")
    private LocalDate startDate;

    @Column(name = "end_date")
    private LocalDate endDate;

    @Column(name = "is_cancelled")
    private boolean cancelled;
}
