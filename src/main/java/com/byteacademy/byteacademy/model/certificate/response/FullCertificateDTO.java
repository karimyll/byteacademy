package com.byteacademy.byteacademy.model.certificate.response;

import com.byteacademy.byteacademy.model.enrollment.response.EnrollmentDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FullCertificateDTO {
    private Long id;
    private String verificationNo;
    private EnrollmentDTO enrollment;
    private Double point;
}
