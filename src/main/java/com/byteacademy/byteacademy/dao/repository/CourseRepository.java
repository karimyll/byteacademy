package com.byteacademy.byteacademy.dao.repository;

import com.byteacademy.byteacademy.dao.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface CourseRepository extends JpaRepository<Course, Long> {
    Optional<Course> findBySlug(String slug);
    @Query("SELECT c FROM Course c JOIN c.teachers t WHERE t.id = :teacherId")
    List<Course> findByTeacherId(Long teacherId);
}
