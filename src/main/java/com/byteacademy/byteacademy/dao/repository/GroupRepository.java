package com.byteacademy.byteacademy.dao.repository;

import com.byteacademy.byteacademy.dao.entity.GroupEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface GroupRepository extends JpaRepository<GroupEntity, Long> {
    Optional<GroupEntity> findByNumber(Long number);
    Boolean existsByNumber(Long number);
}
