package com.byteacademy.byteacademy.dao.entity;

import com.byteacademy.byteacademy.enums.GenderEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "students")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String surname;
    private String fatherName;
    private String username;
    private LocalDate birthDate;
    @Enumerated(EnumType.STRING)
    private GenderEnum gender;

}
