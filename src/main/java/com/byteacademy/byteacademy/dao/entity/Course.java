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
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    @Column(unique = true, nullable = false)
    private String slug;
    private String description;
    private Integer duration;
    private String format;
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Category category;
    @ManyToMany(mappedBy = "course")
    private List<Teacher> teachers;

}
