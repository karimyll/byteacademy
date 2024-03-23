package com.byteacademy.byteacademy.model.certificate.response;

import com.byteacademy.byteacademy.model.enrollment.response.MiniEnrollmentDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MiniCertificateDTO {
    private Long id;
    private String verificationNo;
    private MiniEnrollmentDTO enrollment;
    private Double point;
}
