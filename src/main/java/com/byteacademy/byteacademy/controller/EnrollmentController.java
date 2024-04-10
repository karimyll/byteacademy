package com.byteacademy.byteacademy.controller;

import com.byteacademy.byteacademy.model.EnrollmentDTO;
import com.byteacademy.byteacademy.model.RequestUpdateEnrollmentDTO;
import com.byteacademy.byteacademy.service.interfaces.EnrollmentService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/enrollments")
public class EnrollmentController {
    private final EnrollmentService service;

    @GetMapping
    public Page<EnrollmentDTO> getAllEnrollment(Pageable pageable, HttpServletRequest request){
        return service.getAllEnrollment(pageable, request);
    }

    @GetMapping("/{id}")
    public EnrollmentDTO getById(@PathVariable Long id, HttpServletRequest request){
        return service.getById(id, request);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public EnrollmentDTO add(@RequestBody @Valid EnrollmentDTO registerEnrollmentDTO, HttpServletRequest request){
        return service.add(registerEnrollmentDTO, request);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable Long id, @RequestBody RequestUpdateEnrollmentDTO updateEnrollmentDTO, HttpServletRequest request){
        service.update(id, updateEnrollmentDTO, request);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id, HttpServletRequest request){
        service.delete(id, request);
    }
}
