package com.byteacademy.byteacademy.dao.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "course")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class CourseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String slug;
    private String description;
    private Integer duration;
    private String format;
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private CategoryEntity category;
    @ManyToMany(mappedBy = "course")
    private List<TeacherEntity> teachers;

}
