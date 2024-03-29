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
public class CertificateEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String verificationNo;
    private Double point;
    @OneToOne
    @JoinColumn(name = "enrollment_id")
    private EnrollmentEntity enrollment;
}
