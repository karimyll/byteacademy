package com.byteacademy.byteacademy.dao.repository;

import com.byteacademy.byteacademy.dao.entity.Enrollment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnrollmentRepository extends JpaRepository<Enrollment, Long> {
}
