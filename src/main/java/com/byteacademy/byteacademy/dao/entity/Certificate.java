package com.byteacademy.byteacademy.dao.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "certificate")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Certificate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true, nullable = false)
    private String verificationNo;
    private Double point;
    @OneToOne
    @JoinColumn(name = "enrollment_id")
    private Enrollment enrollment;
}
