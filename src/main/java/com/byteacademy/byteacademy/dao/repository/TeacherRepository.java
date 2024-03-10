package com.byteacademy.byteacademy.dao.repository;

import com.byteacademy.byteacademy.dao.entity.TeacherEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TeacherRepository extends JpaRepository<TeacherEntity, Long> {
    Optional<TeacherEntity> findByUsername(String username);
    Boolean existsByUsername(String username);
}
