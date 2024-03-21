package com.byteacademy.byteacademy.service.interfaces;

import com.byteacademy.byteacademy.model.group.request.RegisterGroupDTO;
import com.byteacademy.byteacademy.model.group.response.ResponseGroupDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface GroupService {
    Page<ResponseGroupDTO> getAllGroups(Pageable pageable);
    ResponseGroupDTO getByGroupNumber(Long number);
    ResponseGroupDTO getById(Long id);
    void add(RegisterGroupDTO registerGroupDTO);
    void update(Long id, RegisterGroupDTO registerGroupDTO);
    void delete(Long id);
}
