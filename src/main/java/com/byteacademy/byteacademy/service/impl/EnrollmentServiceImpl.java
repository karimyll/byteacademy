package com.byteacademy.byteacademy.service.impl;

import com.byteacademy.byteacademy.dao.repository.EnrollmentRepository;
import com.byteacademy.byteacademy.exception.EntityNotFoundException;
import com.byteacademy.byteacademy.mapper.EnrollmentMapper;
import com.byteacademy.byteacademy.model.enrollment.request.RegisterEnrollmentDTO;
import com.byteacademy.byteacademy.model.enrollment.request.UpdateEnrollmentDTO;
import com.byteacademy.byteacademy.model.enrollment.response.EnrollmentDTO;
import com.byteacademy.byteacademy.service.interfaces.EnrollmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EnrollmentServiceImpl implements EnrollmentService {
    private final EnrollmentRepository repository;
    private final EnrollmentMapper mapper;
    @Override
    public Page<EnrollmentDTO> getAllEnrollment(Pageable pageable) {
        return repository.findAll(pageable).map(mapper::mapToDTO);
    }

    @Override
    public EnrollmentDTO getById(Long id) {
        var enrollment = repository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("ENROLLMENT_NOT_FOUND")
        );

        return mapper.mapToDTO(enrollment);
    }

    @Override
    public void add(RegisterEnrollmentDTO registerEnrollmentDTO) {
        registerEnrollmentDTO.setCancelled(false);
        repository.save(mapper.mapToEntity(registerEnrollmentDTO));
    }

    @Override
    public void update(Long id, UpdateEnrollmentDTO updateEnrollmentDTO) {
        var enrollment = repository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("ENROLLMENT_NOT_FOUND")
        );

        repository.save(mapper.mapToUpdateDTO(enrollment, updateEnrollmentDTO));
    }

    @Override
    public void delete(Long id) {
        var enrollment = repository.existsById(id);
        if (enrollment){
            repository.deleteById(id);
        }else{
            throw new EntityNotFoundException("ENROLLMENT_NOT_FOUND");
        }
    }
}
