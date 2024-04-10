package com.byteacademy.byteacademy.service.impl;

import com.byteacademy.byteacademy.dao.repository.StudentRepository;
import com.byteacademy.byteacademy.exception.EntityNotFoundException;
import com.byteacademy.byteacademy.mapper.StudentMapperImpl;
import com.byteacademy.byteacademy.model.RequestUpdateStudentDTO;
import com.byteacademy.byteacademy.model.StudentDTO;
import com.byteacademy.byteacademy.service.auth.AuthService;
import com.byteacademy.byteacademy.service.interfaces.StudentService;
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
public class StudentServiceImpl implements StudentService {
    private final StudentRepository repository;
    private final AuthService authService;
    private final StudentMapperImpl mapper;
    private final ExtractorHelper extractorHelper;

    public String username(HttpServletRequest request) {
        return extractorHelper.extractUsername(request);
    }

    @Override
    public Page<StudentDTO> getAllStudents(Pageable pageable, HttpServletRequest request) {
        log.info("Get all students service used by username: {}", username(request));
        return repository.findAll(pageable).map(mapper::mapToResponseDTO);
    }

    @Override
    public StudentDTO getByUsername(String username, HttpServletRequest request) {
        log.info("Get student service used by username: {}, requested username: {}", username(request), username);
        var student = repository.findByUsername(username).orElseThrow(
                () -> new EntityNotFoundException("STUDENT_NOT_FOUND")
        );
        return mapper.mapToResponseDTO(student);
    }

    @Override
    @Transactional
    public StudentDTO add(StudentDTO registerStudentDTO, HttpServletRequest request) {
        log.info("Add student service started by username: {}", username(request));
        repository.save(mapper.mapToEntity(registerStudentDTO));
        authService.register(registerStudentDTO.getUsername(), registerStudentDTO.getPassword(),
                    registerStudentDTO.getRoles());

        log.info("Student added service finished by username: {}", username(request));
        return registerStudentDTO;
    }

    @Override
    public void update(Long id, RequestUpdateStudentDTO updateStudentDTO, HttpServletRequest request) {
        log.info("Update student service started by username: {}, requested id: {}", username(request), id);
        var student = repository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("STUDENT_NOT_FOUND")
        );
        repository.save(mapper.mapToUpdateEntity(student, updateStudentDTO));
        log.info("Update student service finished by username: {}, requested id: {}", username(request), id);

    }
}
