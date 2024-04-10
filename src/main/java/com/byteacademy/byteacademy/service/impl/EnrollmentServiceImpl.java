package com.byteacademy.byteacademy.service.impl;

import com.byteacademy.byteacademy.dao.repository.EnrollmentRepository;
import com.byteacademy.byteacademy.exception.EntityNotFoundException;
import com.byteacademy.byteacademy.mapper.EnrollmentMapper;
import com.byteacademy.byteacademy.model.EnrollmentDTO;
import com.byteacademy.byteacademy.model.RequestUpdateEnrollmentDTO;
import com.byteacademy.byteacademy.service.interfaces.EnrollmentService;
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
public class EnrollmentServiceImpl implements EnrollmentService {
    private final EnrollmentRepository repository;
    private final EnrollmentMapper mapper;
    private final ExtractorHelper extractorHelper;

    public String username(HttpServletRequest request) {
        return extractorHelper.extractUsername(request);
    }

    @Override
    public Page<EnrollmentDTO> getAllEnrollment(Pageable pageable, HttpServletRequest request) {
        log.info("Enrollment get all service used by username: {}", username(request));
        return repository.findAll(pageable).map(mapper::mapToResponseDTO);
    }

    @Override
    public EnrollmentDTO getById(Long id, HttpServletRequest request) {
        log.info("Enrollment get by id service started by username: {}, id : {}", username(request), id);
        var enrollment = repository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("ENROLLMENT_NOT_FOUND")
        );
        log.info("Enrollment get by id service ended by username: {}, id: {}", username(request), id);
        return mapper.mapToFullResponseDTO(enrollment);
    }

    @Override
    public EnrollmentDTO add(EnrollmentDTO registerEnrollmentDTO, HttpServletRequest request) {
        log.info("Enrollment add service used by username: {}", username(request));
        registerEnrollmentDTO.setCancelled(false);
        repository.save(mapper.mapToEntity(registerEnrollmentDTO));
        log.info("Enrollment add service ended by username: {}", username(request));
        return registerEnrollmentDTO;
    }

    @Override
    public void update(Long id, RequestUpdateEnrollmentDTO updateEnrollmentDTO, HttpServletRequest request) {
        log.info("Enrollment update service used by username: {}, id: {}", username(request), id);
        var enrollment = repository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("ENROLLMENT_NOT_FOUND")
        );
        log.info("Enrollment update service ended by username: {}, id: {}", username(request), id);
        repository.save(mapper.mapToUpdateDTO(enrollment, updateEnrollmentDTO));
    }

    @Override
    public void delete(Long id, HttpServletRequest request) {
        log.info("Enrollment delete service used by username: {}, id: {}", username(request), id);
        repository.deleteById(id);
        log.info("Enrollment delete service ended by username: {}, id: {}", username(request), id);
    }
}
