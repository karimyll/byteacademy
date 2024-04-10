package com.byteacademy.byteacademy.service.interfaces;

import com.byteacademy.byteacademy.model.RequestUpdateTeacherDTO;
import com.byteacademy.byteacademy.model.TeacherDTO;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface TeacherService {
    Page<TeacherDTO> getAllList(Pageable pageable);
    TeacherDTO getByUsername(String username);
    List<TeacherDTO> getByCourseId(Long courseId);
    TeacherDTO add(TeacherDTO registerTeacherDTO, HttpServletRequest request);
    void update(Long id, RequestUpdateTeacherDTO updateTeacherDTO, HttpServletRequest request);
}
