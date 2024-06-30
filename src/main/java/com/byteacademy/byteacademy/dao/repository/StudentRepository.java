package com.byteacademy.byteacademy.dao.repository;

import com.byteacademy.byteacademy.dao.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student, Long> {
    Optional<Student> findByUsername(String username);
}
