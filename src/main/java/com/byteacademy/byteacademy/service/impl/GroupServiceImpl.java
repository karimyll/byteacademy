package com.byteacademy.byteacademy.service.impl;

import com.byteacademy.byteacademy.dao.repository.GroupRepository;
import com.byteacademy.byteacademy.exception.EntityNotFoundException;
import com.byteacademy.byteacademy.mapper.GroupMapper;
import com.byteacademy.byteacademy.model.GroupDTO;
import com.byteacademy.byteacademy.service.interfaces.GroupService;
import com.byteacademy.byteacademy.utility.ExtractorHelper;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class GroupServiceImpl implements GroupService {
    private final GroupRepository repository;
    private final GroupMapper mapper;
    private final ExtractorHelper extractorHelper;

    public String username(HttpServletRequest request) {
        return extractorHelper.extractUsername(request);
    }

    @Override
    public Page<GroupDTO> getAllGroups(Pageable pageable, HttpServletRequest request) {
        log.info("Getting all groups by username {}", username(request));
        return repository.findAll(pageable).map(mapper::mapToDTO);
    }

    @Override
    public GroupDTO getByGroupNumber(Long number, HttpServletRequest request) {
        log.info("Getting group by number service started by username: {}, number: {}", username(request), number);
        var group = repository.findByNumber(number).orElseThrow(
                () -> new EntityNotFoundException("GROUP_NOT_FOUND_BY_NUMBER")
        );
        log.info("Getting group by number service ended by username: {}, number: {}", username(request), number);
        return mapper.mapToDTO(group);
    }

    @Override
    public GroupDTO getById(Long id, HttpServletRequest request) {
        log.info("Getting group by id service started by username: {}, id: {}", username(request), id);
        var group = repository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("GROUP_NOT_FOUND_BY_ID")
        );
        log.info("Getting group by id service finished by username: {}, id: {}", username(request), id);
        return mapper.mapToDTO(group);
    }

    @Override
    public GroupDTO add(GroupDTO registerGroupDTO, HttpServletRequest request) {
        log.info("Adding group service started by username: {}", username(request));
        repository.save(mapper.mapToEntity(registerGroupDTO));
        log.info("Adding group service ended by username: {}", username(request));
        return registerGroupDTO;
    }

    @Override
    public void update(Long id, GroupDTO registerGroupDTO, HttpServletRequest request) {
        log.info("Updating group service started by username: {}, id: {}", username(request), id);
        var group = repository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("GROUP_NOT_FOUND")
        );
        log.info("Updating group service ended by username: {}, id: {}", username(request), id);
        repository.save(mapper.mapToUpdateEntity(group, registerGroupDTO));
    }

    @Override
    public void delete(Long id, HttpServletRequest request) {
        log.info("Deleting group service started by username: {}, id: {}", username(request), id);
        repository.deleteById(id);
        log.info("Deleting group service ended by username: {}, id: {}", username(request), id);
    }
}
