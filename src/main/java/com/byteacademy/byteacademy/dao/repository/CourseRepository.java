package com.byteacademy.byteacademy.dao.repository;

import com.byteacademy.byteacademy.dao.entity.CourseEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CourseRepository extends JpaRepository<CourseEntity, Long> {
    Optional<CourseEntity> findBySlug(String slug);
}
