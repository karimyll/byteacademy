package com.byteacademy.byteacademy.service.interfaces;

import com.byteacademy.byteacademy.model.CertificateDTO;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CertificateService {
    Page<CertificateDTO> getAllList(Pageable pageable, HttpServletRequest request);
    CertificateDTO getByVerificationNo(String verificationNo);
    CertificateDTO add(CertificateDTO certificateDTO, HttpServletRequest request);
    void update(Long id, CertificateDTO certificateDTO, HttpServletRequest request);
    void deleteById(Long id, HttpServletRequest request);
}
