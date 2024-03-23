package com.byteacademy.byteacademy.controller;

import com.byteacademy.byteacademy.model.certificate.request.RegisterCertificateDTO;
import com.byteacademy.byteacademy.model.certificate.response.FullCertificateDTO;
import com.byteacademy.byteacademy.model.certificate.response.MiniCertificateDTO;
import com.byteacademy.byteacademy.service.interfaces.CertificateService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/certificate")
@RequiredArgsConstructor
public class CertificateController {
    private final CertificateService service;

    @GetMapping
    public Page<MiniCertificateDTO> getAllList(Pageable pageable){
        return service.getAllList(pageable);
    }

    @GetMapping("/full")
    public Page<FullCertificateDTO> getFullList(Pageable pageable){
        return service.getFullList(pageable);
    }

    @GetMapping("/no/{verificationNo}")
    public FullCertificateDTO getByVerificationNo(@PathVariable String verificationNo){
        return service.getByVerificationNo(verificationNo);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void add(@RequestBody @Valid RegisterCertificateDTO registerCertificateDTO){
        service.add(registerCertificateDTO);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable Long id, @RequestBody RegisterCertificateDTO certificateDTO){
        service.update(id, certificateDTO);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Long id){
        service.deleteById(id);
    }
}
