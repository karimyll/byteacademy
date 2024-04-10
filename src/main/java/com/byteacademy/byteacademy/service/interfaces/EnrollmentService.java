package com.byteacademy.byteacademy.service.interfaces;

import com.byteacademy.byteacademy.model.EnrollmentDTO;
import com.byteacademy.byteacademy.model.RequestUpdateEnrollmentDTO;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface EnrollmentService {
    Page<EnrollmentDTO> getAllEnrollment(Pageable pageable, HttpServletRequest request);
    EnrollmentDTO getById(Long id, HttpServletRequest request);
    EnrollmentDTO add(EnrollmentDTO registerEnrollmentDTO, HttpServletRequest request);
    void update(Long id, RequestUpdateEnrollmentDTO updateEnrollmentDTO, HttpServletRequest request);
    void delete(Long id, HttpServletRequest request);
}
