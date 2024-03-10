package com.byteacademy.byteacademy.service.interfaces;

import com.byteacademy.byteacademy.model.teacher.request.RegisterTeacherDTO;
import com.byteacademy.byteacademy.model.teacher.request.UpdateTeacherDTO;
import com.byteacademy.byteacademy.model.teacher.response.DetailedTeacherDTO;
import com.byteacademy.byteacademy.model.teacher.response.MiniTeacherDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface TeacherService {
    Page<MiniTeacherDTO> getAllList(Pageable pageable);
    DetailedTeacherDTO getByUsername(String username);
    void add(RegisterTeacherDTO registerTeacherDTO);
    void update(Long id, UpdateTeacherDTO updateTeacherDTO);
}
