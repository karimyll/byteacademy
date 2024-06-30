package com.byteacademy.byteacademy.service.impl;

import com.byteacademy.byteacademy.dao.repository.ApplicationRepository;
import com.byteacademy.byteacademy.enums.StatusEnum;
import com.byteacademy.byteacademy.exception.EntityNotFoundException;
import com.byteacademy.byteacademy.mapper.ApplicationMapper;
import com.byteacademy.byteacademy.model.ApplicationDTO;
import com.byteacademy.byteacademy.service.interfaces.ApplicationService;
import com.byteacademy.byteacademy.utility.ExtractorHelper;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
@Slf4j
public class ApplicationServiceImpl implements ApplicationService {

    private final ApplicationRepository applicationRepository;
    private final ApplicationMapper applicationMapper;
    private final ExtractorHelper extractorHelper;

    public String username(HttpServletRequest request) {
        return extractorHelper.extractUsername(request);
    }

    @Override
    public Page<ApplicationDTO> getAll(Pageable pageable, HttpServletRequest request) {
        log.info("Application get all service used by username: {}", username(request));
        return applicationRepository.findAll(pageable).map(applicationMapper::mapToDTO);
    }

    @Override
    public ApplicationDTO getById(Long id, HttpServletRequest request) {
        log.info("Application get by id service used by username: {}, requested id: {}", username(request), id);
        var application = applicationRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("APPLICATION_NOT_FOUND"));

        return applicationMapper.mapToDTO(application);
    }

    @Override
    public ApplicationDTO save(ApplicationDTO applicationDTO) {
        log.info("Application save service started by phone number: {}", applicationDTO.getPhoneNumber());
        applicationDTO.setStatus(StatusEnum.valueOf("PENDING"));
        applicationRepository.save(applicationMapper.mapToEntity(applicationDTO));
        log.info("Application save service finished by phone number: {}", applicationDTO.getPhoneNumber());
        return applicationDTO;
    }

    @Override
    public void update(Long id, ApplicationDTO applicationDTO, HttpServletRequest request) {
        log.info("Application update service started by username: {}, requested id: {}", username(request), id);
        var existingApplication = applicationRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("APPLICATION_NOT_FOUND"));

        applicationRepository.save(applicationMapper.mapUpdateDtoToEntity(existingApplication, applicationDTO));

        log.info("Application update service finished by username: {}, requested id: {}", username(request), id);
    }

    @Override
    public void delete(Long id, HttpServletRequest request) {
        log.info("Application delete service started by username: {}, requested id: {}", username(request), id);
        applicationRepository.deleteById(id);
        log.info("Application delete service finished by username: {}, requested id: {}", username(request), id);
    }
}
