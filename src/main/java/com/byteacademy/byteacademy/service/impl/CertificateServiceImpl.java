package com.byteacademy.byteacademy.service.impl;

import com.byteacademy.byteacademy.dao.repository.CertificateRepository;
import com.byteacademy.byteacademy.exception.EntityNotFoundException;
import com.byteacademy.byteacademy.mapper.CertificateMapper;
import com.byteacademy.byteacademy.model.CertificateDTO;
import com.byteacademy.byteacademy.service.interfaces.CertificateService;
import com.byteacademy.byteacademy.utility.ExtractorHelper;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class CertificateServiceImpl implements CertificateService {
    private final CertificateRepository repository;
    private final CertificateMapper mapper;
    private final ExtractorHelper extractorHelper;

    public String username(HttpServletRequest request) {
        return extractorHelper.extractUsername(request);
    }

    @Override
    public Page<CertificateDTO> getAllList(Pageable pageable, HttpServletRequest request) {
        log.info("Certificate get all list service used by username: {}", username(request));
        return repository.findAll(pageable).map(mapper::mapToResponse);
    }

    @Override
    public CertificateDTO getByVerificationNo(String verificationNo) {
        log.info("Certificate get by verification no: {}", verificationNo);
        var certificate = repository.findByVerificationNo(verificationNo).orElseThrow(
                () -> new EntityNotFoundException("CERTIFICATE_NOT_FOUND")
        );

        return mapper.mapToFullResponse(certificate);
    }

    @Override
    public CertificateDTO add(CertificateDTO certificateDTO, HttpServletRequest request) {
        log.info("Certificate add service started by username: {}", username(request));
        repository.save(mapper.mapToEntity(certificateDTO));
        log.info("Certificate add service finished by username: {}", username(request));
        return certificateDTO;
    }

    @Override
    public void update(Long id, CertificateDTO certificateDTO, HttpServletRequest request) {
        log.info("Certificate update service started by username: {}, id: {}", username(request), id);
        var certificate = repository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("CERTIFICATE_NOT_FOUND")
        );

        repository.save(mapper.mapToUpdateEntity(certificate, certificateDTO));

        log.info("Certificate update service finished by username: {}", username(request));
    }

    @Override
    public void deleteById(Long id, HttpServletRequest request) {
        log.info("Certificate delete service started by username: {}, id: {}", username(request), id);
        repository.deleteById(id);
        log.info("Certificate delete service finished by username: {}, id : {}", username(request), id);
    }
}
