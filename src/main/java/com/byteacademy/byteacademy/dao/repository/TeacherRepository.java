package com.byteacademy.byteacademy.dao.repository;

import com.byteacademy.byteacademy.dao.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TeacherRepository extends JpaRepository<Teacher, Long> {
    Optional<Teacher> findByUsername(String username);
    List<Teacher> findByCourseId(Long courseId);
}
