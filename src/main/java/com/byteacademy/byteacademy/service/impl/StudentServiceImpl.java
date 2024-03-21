package com.byteacademy.byteacademy.service.impl;

import com.byteacademy.byteacademy.dao.repository.StudentRepository;
import com.byteacademy.byteacademy.exception.EntityExistException;
import com.byteacademy.byteacademy.exception.EntityNotFoundException;
import com.byteacademy.byteacademy.mapper.StudentMapperImpl;
import com.byteacademy.byteacademy.model.student.request.RegisterStudentDTO;
import com.byteacademy.byteacademy.model.student.request.UpdateStudentDTO;
import com.byteacademy.byteacademy.model.student.response.FullStudentDTO;
import com.byteacademy.byteacademy.service.auth.AuthService;
import com.byteacademy.byteacademy.service.interfaces.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {
    private final StudentRepository repository;
    private final AuthService authService;
    private final StudentMapperImpl mapper;

    @Override
    public Page<FullStudentDTO> getAllStudents(Pageable pageable) {
        return repository.findAll(pageable).map(mapper::mapToFullDTO);
    }

    @Override
    public FullStudentDTO getByUsername(String username) {
        var student = repository.findByUsername(username).orElseThrow(
                () -> new EntityNotFoundException("STUDENT_NOT_FOUND")
        );

        return mapper.mapToFullDTO(student);
    }

    @Override
    @Transactional
    public void add(RegisterStudentDTO registerStudentDTO) {
        var check = repository.existsByUsername(registerStudentDTO.getUsername());
        if (check){
            throw new EntityExistException("STUDENT_EXIST_WITH_THIS_USERNAME");
        }else {
            repository.save(mapper.mapToEntity(registerStudentDTO));
            authService.register(registerStudentDTO.getUsername(), registerStudentDTO.getPassword(),
                    registerStudentDTO.getRoles());
        }
    }

    @Override
    public void update(Long id, UpdateStudentDTO updateStudentDTO) {
        var student = repository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("STUDENT_NOT_FOUND")
        );

        repository.save(mapper.mapToUpdateEntity(student, updateStudentDTO));
    }
}
