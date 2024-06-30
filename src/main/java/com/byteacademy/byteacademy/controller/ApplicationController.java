package com.byteacademy.byteacademy.controller;

import com.byteacademy.byteacademy.model.ApplicationDTO;
import com.byteacademy.byteacademy.service.interfaces.ApplicationService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/applications")
@RequiredArgsConstructor
public class ApplicationController {

    private final ApplicationService applicationService;

    @GetMapping
    public Page<ApplicationDTO> getAll(Pageable pageable, HttpServletRequest request){
        return applicationService.getAll(pageable, request);
    }

    @GetMapping("/{id}")
    public ApplicationDTO getById(@PathVariable Long id, HttpServletRequest request){
        return applicationService.getById(id, request);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void save(@RequestBody @Valid ApplicationDTO applicationDTO){
        applicationService.save(applicationDTO);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable Long id, @RequestBody ApplicationDTO applicationDTO, HttpServletRequest request){
        applicationService.update(id, applicationDTO, request);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id, HttpServletRequest request){
        applicationService.delete(id, request);
    }

}
