package com.byteacademy.byteacademy.service.interfaces;

import com.byteacademy.byteacademy.model.GroupDTO;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface GroupService {
    Page<GroupDTO> getAllGroups(Pageable pageable, HttpServletRequest request);
    GroupDTO getByGroupNumber(Long number, HttpServletRequest request);
    GroupDTO getById(Long id, HttpServletRequest request);
    GroupDTO add(GroupDTO registerGroupDTO, HttpServletRequest request);
    void update(Long id, GroupDTO registerGroupDTO, HttpServletRequest request);
    void delete(Long id, HttpServletRequest request);
}
