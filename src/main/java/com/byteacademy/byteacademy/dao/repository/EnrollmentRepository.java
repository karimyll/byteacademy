package com.byteacademy.byteacademy.dao.repository;

import com.byteacademy.byteacademy.dao.entity.EnrollmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnrollmentRepository extends JpaRepository<EnrollmentEntity, Long> {
}
