package com.byteacademy.byteacademy.service.interfaces;

import com.byteacademy.byteacademy.model.ApplicationDTO;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface ApplicationService {
    Page<ApplicationDTO> getAll(Pageable pageable, HttpServletRequest request);
    ApplicationDTO getById(Long id, HttpServletRequest request);
    ApplicationDTO save(ApplicationDTO applicationDTO);
    void update(Long id, ApplicationDTO applicationDTO, HttpServletRequest request);
    void delete(Long id, HttpServletRequest request);
}
