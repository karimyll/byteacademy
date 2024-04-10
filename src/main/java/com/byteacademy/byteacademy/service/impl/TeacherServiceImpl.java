package com.byteacademy.byteacademy.service.impl;

import com.byteacademy.byteacademy.dao.repository.TeacherRepository;
import com.byteacademy.byteacademy.exception.EntityNotFoundException;
import com.byteacademy.byteacademy.mapper.TeacherMapper;
import com.byteacademy.byteacademy.model.RequestUpdateTeacherDTO;
import com.byteacademy.byteacademy.model.TeacherDTO;
import com.byteacademy.byteacademy.service.auth.AuthService;
import com.byteacademy.byteacademy.service.interfaces.TeacherService;
import com.byteacademy.byteacademy.utility.ExtractorHelper;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class TeacherServiceImpl implements TeacherService {
    private final TeacherRepository repository;
    private final TeacherMapper mapper;
    private final AuthService authService;
    public final ExtractorHelper extractorHelper;

    public String username(HttpServletRequest request) {
        return extractorHelper.extractUsername(request);
    }

    @Override
    public Page<TeacherDTO> getAllList(Pageable pageable) {
        log.info("Teacher get all list method used");
        return repository.findAll(pageable).map(mapper::mapToResponse);
    }

    @Override
    public TeacherDTO getByUsername(String username) {
        log.info("Teacher get by username service used, requested username: {}", username);
        var teacher = repository.findByUsername(username).orElseThrow(
                () -> new EntityNotFoundException("TEACHER_NOT_FOUND")
        );
        return mapper.mapToResponse(teacher);
    }

    @Override
    public List<TeacherDTO> getByCourseId(Long courseId) {
        log.info("Teacher get by course service used, requested courseId: {}", courseId);
        var teacher = repository.findByCourseId(courseId);
        return teacher.stream()
                .map(mapper::mapToResponse)
                .toList();
    }

    @Override
    @Transactional
    public TeacherDTO add(TeacherDTO registerTeacherDTO, HttpServletRequest request) {
        log.info("Teacher add service started by username: {}", username(request));
        repository.save(mapper.mapToEntity(registerTeacherDTO));
        authService.register(registerTeacherDTO.getUsername(), registerTeacherDTO.getPassword(), registerTeacherDTO.getRoles());
        log.info("Teacher add service finished by username: {}", username(request));
        return registerTeacherDTO;
    }

    @Override
    public void update(Long id, RequestUpdateTeacherDTO updateTeacherDTO, HttpServletRequest request) {
        log.info("Teacher update service started by username: {}", username(request));
        var teacher = repository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("TEACHER_NOT_FOUND")
        );
        log.info("Teacher update service finished by username: {}", username(request));
        repository.save(mapper.mapUpdateToEntity(teacher, updateTeacherDTO));
    }



}
