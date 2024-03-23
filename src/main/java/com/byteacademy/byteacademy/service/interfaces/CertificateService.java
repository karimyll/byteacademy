package com.byteacademy.byteacademy.service.interfaces;

import com.byteacademy.byteacademy.model.certificate.request.RegisterCertificateDTO;
import com.byteacademy.byteacademy.model.certificate.response.FullCertificateDTO;
import com.byteacademy.byteacademy.model.certificate.response.MiniCertificateDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CertificateService {
    Page<MiniCertificateDTO> getAllList(Pageable pageable);
    Page<FullCertificateDTO> getFullList(Pageable pageable);
    FullCertificateDTO getByVerificationNo(String verificationNo);
    void add(RegisterCertificateDTO registerCertificateDTO);
    void update(Long id, RegisterCertificateDTO certificateDTO);
    void deleteById(Long id);
}
