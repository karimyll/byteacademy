package com.byteacademy.byteacademy.service.impl;

import com.byteacademy.byteacademy.dao.repository.TeacherRepository;
import com.byteacademy.byteacademy.exception.EntityExistException;
import com.byteacademy.byteacademy.exception.EntityNotFoundException;
import com.byteacademy.byteacademy.mapper.TeacherMapper;
import com.byteacademy.byteacademy.model.teacher.request.RegisterTeacherDTO;
import com.byteacademy.byteacademy.model.teacher.request.UpdateTeacherDTO;
import com.byteacademy.byteacademy.model.teacher.response.DetailedTeacherDTO;
import com.byteacademy.byteacademy.model.teacher.response.MiniTeacherDTO;
import com.byteacademy.byteacademy.service.auth.AuthService;
import com.byteacademy.byteacademy.service.interfaces.TeacherService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class TeacherServiceImpl implements TeacherService {
    private final TeacherRepository repository;
    private final TeacherMapper mapper;
    private final AuthService authService;

    @Override
    public Page<MiniTeacherDTO> getAllList(Pageable pageable) {
        return repository.findAll(pageable).map(mapper::mapToMiniDTO);
    }

    @Override
    public DetailedTeacherDTO getByUsername(String username) {
        var teacher = repository.findByUsername(username).orElseThrow(
                () -> new EntityNotFoundException("TEACHER_NOT_FOUND")
        );

        return mapper.mapToDetailedDTO(teacher);
    }

    @Override
    @Transactional
    public void add(RegisterTeacherDTO registerTeacherDTO) {
        var check = repository.existsByUsername(registerTeacherDTO.getUsername());
        if (check){
            throw new EntityExistException("TEACHER_EXIST_WITH_THIS_USERNAME");
        }else{
            repository.save(mapper.mapToEntity(registerTeacherDTO));
            authService.register(registerTeacherDTO.getUsername(), registerTeacherDTO.getPassword(), registerTeacherDTO.getRoles());
        }
    }

    @Override
    public void update(Long id, UpdateTeacherDTO updateTeacherDTO) {
        var teacher = repository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("TEACHER_NOT_FOUND")
        );

        repository.save(mapper.mapUpdateToEntity(teacher, updateTeacherDTO));
    }



}
