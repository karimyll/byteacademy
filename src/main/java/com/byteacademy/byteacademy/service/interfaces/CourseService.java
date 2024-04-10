package com.byteacademy.byteacademy.service.interfaces;

import com.byteacademy.byteacademy.model.CourseDTO;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CourseService {
    Page<CourseDTO> getAllList(Pageable pageable);
    CourseDTO getBySlug(String slug);
    List<CourseDTO> getByTeacherId(Long teacherId);
    CourseDTO add(CourseDTO courseDTO, HttpServletRequest request);
    void update(Long id, CourseDTO courseDTO, HttpServletRequest request);
    void delete(Long id, HttpServletRequest request);

}
