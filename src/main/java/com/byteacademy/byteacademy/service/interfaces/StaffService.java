package com.byteacademy.byteacademy.service.interfaces;

import com.byteacademy.byteacademy.model.StaffDTO;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface StaffService {
    Page<StaffDTO> getAll(Pageable pageable, HttpServletRequest request);
    StaffDTO getById(Long id, HttpServletRequest request);
    StaffDTO save(StaffDTO staffDTO, HttpServletRequest request);
    void delete(Long id, HttpServletRequest request);
    void update(Long id, StaffDTO staffDTO, HttpServletRequest request);
}
