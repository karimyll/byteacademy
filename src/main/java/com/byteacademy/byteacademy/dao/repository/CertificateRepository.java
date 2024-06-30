package com.byteacademy.byteacademy.dao.repository;

import com.byteacademy.byteacademy.dao.entity.Certificate;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CertificateRepository extends JpaRepository<Certificate, Long> {
    Optional<Certificate> findByVerificationNo(String verificationNo);
}
