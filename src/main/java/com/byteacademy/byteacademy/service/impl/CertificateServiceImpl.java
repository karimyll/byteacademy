package com.byteacademy.byteacademy.service.impl;

import com.byteacademy.byteacademy.dao.repository.CertificateRepository;
import com.byteacademy.byteacademy.exception.EntityExistException;
import com.byteacademy.byteacademy.exception.EntityNotFoundException;
import com.byteacademy.byteacademy.mapper.CertificateMapper;
import com.byteacademy.byteacademy.model.certificate.request.RegisterCertificateDTO;
import com.byteacademy.byteacademy.model.certificate.response.FullCertificateDTO;
import com.byteacademy.byteacademy.model.certificate.response.MiniCertificateDTO;
import com.byteacademy.byteacademy.service.interfaces.CertificateService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CertificateServiceImpl implements CertificateService {
    private final CertificateRepository repository;
    private final CertificateMapper mapper;

    @Override
    public Page<MiniCertificateDTO> getAllList(Pageable pageable) {
        return repository.findAll(pageable).map(mapper::mapToMiniDTO);
    }

    @Override
    public Page<FullCertificateDTO> getFullList(Pageable pageable) {
        return repository.findAll(pageable).map(mapper::mapToFullDTO);
    }

    @Override
    public FullCertificateDTO getByVerificationNo(String verificationNo) {
        var certificate = repository.findByVerificationNo(verificationNo).orElseThrow(
                () -> new EntityNotFoundException("CERTIFICATE_NOT_FOUND")
        );

        return mapper.mapToFullDTO(certificate);
    }

    @Override
    public void add(RegisterCertificateDTO registerCertificateDTO) {
        var check = repository.existsByVerificationNo(registerCertificateDTO.getVerificationNo());
        if (check){
            throw new EntityExistException("CERTIFICATE_WITH_THIS_NO_IS_ALREADY_EXISTS");
        }else{
            repository.save(mapper.mapToEntity(registerCertificateDTO));
        }
    }

    @Override
    public void update(Long id, RegisterCertificateDTO certificateDTO) {
        var certificate = repository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("CERTIFICATE_NOT_FOUND")
        );

        repository.save(mapper.mapToUpdateEntity(certificate, certificateDTO));
    }

    @Override
    public void deleteById(Long id) {
        var check = repository.existsById(id);
        if (check){
            repository.deleteById(id);
        }else {
            throw new EntityNotFoundException("CERTIFICATE_NOT_FOUND");
        }
    }
}
