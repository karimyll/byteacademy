package com.byteacademy.byteacademy.controller;

import com.byteacademy.byteacademy.model.StaffDTO;
import com.byteacademy.byteacademy.service.interfaces.StaffService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/staff")
@RequiredArgsConstructor
public class StaffController {
    private final StaffService service;

    @GetMapping
    public Page<StaffDTO> getAll(Pageable pageable, HttpServletRequest request){
        return service.getAll(pageable, request);
    }

    @GetMapping("/{id}")
    public StaffDTO getById(@PathVariable Long id, HttpServletRequest request){
        return service.getById(id, request);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public StaffDTO save(@RequestBody @Valid StaffDTO staffDTO, HttpServletRequest request){
        return service.save(staffDTO, request);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id, HttpServletRequest request){
        service.delete(id, request);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable Long id, StaffDTO staffDTO, HttpServletRequest request){
        service.update(id, staffDTO, request);
    }

}
