package com.byteacademy.byteacademy.service.interfaces;

import com.byteacademy.byteacademy.model.enrollment.request.RegisterEnrollmentDTO;
import com.byteacademy.byteacademy.model.enrollment.request.UpdateEnrollmentDTO;
import com.byteacademy.byteacademy.model.enrollment.response.EnrollmentDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface EnrollmentService {
    Page<EnrollmentDTO> getAllEnrollment(Pageable pageable);
    EnrollmentDTO getById(Long id);
    void add(RegisterEnrollmentDTO registerEnrollmentDTO);
    void update(Long id, UpdateEnrollmentDTO updateEnrollmentDTO);
    void delete(Long id);
}
