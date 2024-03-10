package com.byteacademy.byteacademy.dao.repository;

import com.byteacademy.byteacademy.dao.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity, Long>, JpaSpecificationExecutor<UserEntity> {
    Optional<UserEntity> findUserByUsername(String username);
    void deleteByUsername(String username);
}
