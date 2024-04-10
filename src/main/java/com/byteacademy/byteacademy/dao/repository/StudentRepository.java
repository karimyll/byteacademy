package com.byteacademy.byteacademy.dao.repository;

import com.byteacademy.byteacademy.dao.entity.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StudentRepository extends JpaRepository<StudentEntity, Long> {
    Optional<StudentEntity> findByUsername(String username);
}
