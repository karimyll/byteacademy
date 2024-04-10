package com.byteacademy.byteacademy.service.interfaces;

import com.byteacademy.byteacademy.model.StudentDTO;
import com.byteacademy.byteacademy.model.RequestUpdateStudentDTO;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface StudentService {
    Page<StudentDTO> getAllStudents(Pageable pageable, HttpServletRequest request);
    StudentDTO getByUsername(String username, HttpServletRequest request);
    StudentDTO add(StudentDTO registerStudentDTO, HttpServletRequest request);
    void update(Long id, RequestUpdateStudentDTO updateStudentDTO, HttpServletRequest request);
}
