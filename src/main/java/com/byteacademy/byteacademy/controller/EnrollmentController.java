package com.byteacademy.byteacademy.controller;

import com.byteacademy.byteacademy.model.enrollment.request.RegisterEnrollmentDTO;
import com.byteacademy.byteacademy.model.enrollment.request.UpdateEnrollmentDTO;
import com.byteacademy.byteacademy.model.enrollment.response.EnrollmentDTO;
import com.byteacademy.byteacademy.service.interfaces.EnrollmentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/enrollment")
public class EnrollmentController {
    private final EnrollmentService service;

    @GetMapping
    public Page<EnrollmentDTO> getAllEnrollment(Pageable pageable){
        return service.getAllEnrollment(pageable);
    }

    @GetMapping("/{id}")
    public EnrollmentDTO getById(@PathVariable Long id){
        return service.getById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void add(@RequestBody @Valid RegisterEnrollmentDTO registerEnrollmentDTO){
        service.add(registerEnrollmentDTO);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable Long id, @RequestBody UpdateEnrollmentDTO updateEnrollmentDTO){
        service.update(id, updateEnrollmentDTO);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id){
        service.delete(id);
    }
}
