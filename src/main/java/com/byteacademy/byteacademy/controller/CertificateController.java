package com.byteacademy.byteacademy.controller;

import com.byteacademy.byteacademy.model.CertificateDTO;
import com.byteacademy.byteacademy.service.interfaces.CertificateService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/certificates")
@RequiredArgsConstructor
public class CertificateController {
    private final CertificateService service;

    @GetMapping
    public Page<CertificateDTO> getAllList(Pageable pageable, HttpServletRequest request){
        return service.getAllList(pageable ,request);
    }

    @GetMapping("/no/{verificationNo}")
    public CertificateDTO getByVerificationNo(@PathVariable String verificationNo){
        return service.getByVerificationNo(verificationNo);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CertificateDTO add(@RequestBody @Valid CertificateDTO certificateDTO, HttpServletRequest request){
        service.add(certificateDTO, request);
        return certificateDTO;
    }

    @PutMapping("/{id}")
    public void update(@PathVariable Long id, @RequestBody CertificateDTO certificateDTO, HttpServletRequest request){
        service.update(id, certificateDTO, request);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Long id, HttpServletRequest request){
        service.deleteById(id, request);
    }
}
