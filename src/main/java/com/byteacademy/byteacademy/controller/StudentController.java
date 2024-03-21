package com.byteacademy.byteacademy.controller;

import com.byteacademy.byteacademy.model.student.request.RegisterStudentDTO;
import com.byteacademy.byteacademy.model.student.request.UpdateStudentDTO;
import com.byteacademy.byteacademy.model.student.response.FullStudentDTO;
import com.byteacademy.byteacademy.service.interfaces.StudentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/student")
public class StudentController {
    private final StudentService service;
    @GetMapping
    public Page<FullStudentDTO> getAllStudents(Pageable pageable){
        return service.getAllStudents(pageable);
    }

    @GetMapping("/{username}")
    public FullStudentDTO getByUsername(@PathVariable String username){
        return service.getByUsername(username);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void add(@RequestBody @Valid RegisterStudentDTO registerStudentDTO){
        service.add(registerStudentDTO);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable Long id, @RequestBody @Valid UpdateStudentDTO updateStudentDTO){
        service.update(id, updateStudentDTO);
    }
}
