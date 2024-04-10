package com.byteacademy.byteacademy.dao.repository;

import com.byteacademy.byteacademy.dao.entity.CourseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface CourseRepository extends JpaRepository<CourseEntity, Long> {
    Optional<CourseEntity> findBySlug(String slug);
    @Query("SELECT c FROM CourseEntity c JOIN c.teachers t WHERE t.id = :teacherId")
    List<CourseEntity> findByTeacherId(Long teacherId);
}
