package com.byteacademy.byteacademy.controller;

import com.byteacademy.byteacademy.model.RequestUpdateStudentDTO;
import com.byteacademy.byteacademy.model.StudentDTO;
import com.byteacademy.byteacademy.service.interfaces.StudentService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/students")
public class StudentController {
    private final StudentService service;

    @GetMapping
    public Page<StudentDTO> getAllStudents(Pageable pageable, HttpServletRequest request){
        return service.getAllStudents(pageable, request);
    }

    @GetMapping("/{username}")
    public StudentDTO getByUsername(@PathVariable String username, HttpServletRequest request){
        return service.getByUsername(username, request);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public StudentDTO add(@RequestBody @Valid StudentDTO registerStudentDTO, HttpServletRequest request){
        return service.add(registerStudentDTO, request);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable Long id, @RequestBody RequestUpdateStudentDTO updateStudentDTO, HttpServletRequest request){
        service.update(id, updateStudentDTO, request);
    }
}
