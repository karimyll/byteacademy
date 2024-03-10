package com.byteacademy.byteacademy.dao.repository;


import com.byteacademy.byteacademy.dao.entity.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface  RoleRepository extends JpaRepository<RoleEntity, Integer> {
}
