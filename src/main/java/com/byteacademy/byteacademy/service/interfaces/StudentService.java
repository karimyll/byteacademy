package com.byteacademy.byteacademy.service.interfaces;

import com.byteacademy.byteacademy.model.student.request.RegisterStudentDTO;
import com.byteacademy.byteacademy.model.student.request.UpdateStudentDTO;
import com.byteacademy.byteacademy.model.student.response.FullStudentDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface StudentService {
    Page<FullStudentDTO> getAllStudents(Pageable pageable);
    FullStudentDTO getByUsername(String username);
    void add(RegisterStudentDTO registerStudentDTO);
    void update(Long id, UpdateStudentDTO updateStudentDTO);
}
