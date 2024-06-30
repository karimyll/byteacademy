package com.byteacademy.byteacademy.service.impl;

import com.byteacademy.byteacademy.dao.repository.StaffRepository;
import com.byteacademy.byteacademy.exception.EntityNotFoundException;
import com.byteacademy.byteacademy.mapper.StaffMapper;
import com.byteacademy.byteacademy.model.StaffDTO;
import com.byteacademy.byteacademy.service.auth.AuthService;
import com.byteacademy.byteacademy.service.interfaces.StaffService;
import com.byteacademy.byteacademy.utility.ExtractorHelper;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Slf4j
public class StaffServiceImpl implements StaffService {
    private final StaffRepository repository;
    private final StaffMapper mapper;
    private final ExtractorHelper extractorHelper;
    private final AuthService authService;

    public String username(HttpServletRequest request) {
        return extractorHelper.extractUsername(request);
    }

    @Override
    public Page<StaffDTO> getAll(Pageable pageable, HttpServletRequest request) {
        log.info("Staff get all service used by username: {}", username(request));
        return repository.findAll(pageable).map(mapper::mapToDTO);
    }

    @Override
    public StaffDTO getById(Long id, HttpServletRequest request) {
        log.info("Staff get service started by username: {}, requested id: {}", username(request), id);
        var staff = repository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("STAFF_NOT_FOUND_BY_ID")
        );
        log.info("Staff get service finished by username: {}, requested id: {}", username(request), id);
        return mapper.mapToDTO(staff);
    }

    @Override
    @Transactional
    public StaffDTO save(StaffDTO staffDTO, HttpServletRequest request) {
        log.info("Staff save service started by username: {}", username(request));
        repository.save(mapper.mapToEntity(staffDTO));
        authService.register(staffDTO.getUsername(), staffDTO.getPassword(), staffDTO.getRoles());
        log.info("Staff save service finished by username: {}", username(request));
        return staffDTO;
    }

    @Override
    public void delete(Long id, HttpServletRequest request) {
        log.info("Staff delete service started by username: {}, requested id: {}", username(request), id);
        repository.deleteById(id);
        log.info("Staff delete service finished by username: {}, requested id: {}", username(request), id);
    }

    @Override
    public void update(Long id, StaffDTO staffDTO, HttpServletRequest request) {
        log.info("Staff update service started by username: {}, requested id: {}", username(request), id);
        var existingStaff = repository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("STAFF_NOT_FOUND_BY_ID")
        );

        repository.save(mapper.mapToUpdateEntity(existingStaff, staffDTO));
        log.info("Staff update service finished by username: {}, requested id: {}", username(request), id);
    }
}
