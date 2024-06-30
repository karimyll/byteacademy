package com.byteacademy.byteacademy.dao.repository;


import com.byteacademy.byteacademy.dao.entity.Application;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApplicationRepository extends JpaRepository<Application, Long> {
}
