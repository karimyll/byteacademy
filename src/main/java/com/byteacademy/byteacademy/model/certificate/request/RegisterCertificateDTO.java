package com.byteacademy.byteacademy.model.certificate.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegisterCertificateDTO {
    private Long enrollmentId;
    private Double point;
    private String verificationNo;
}
