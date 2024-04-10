package com.byteacademy.byteacademy.dao.repository;

import com.byteacademy.byteacademy.dao.entity.CertificateEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CertificateRepository extends JpaRepository<CertificateEntity, Long> {
    Optional<CertificateEntity> findByVerificationNo(String verificationNo);
}
