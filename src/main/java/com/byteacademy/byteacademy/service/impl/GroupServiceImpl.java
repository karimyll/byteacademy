package com.byteacademy.byteacademy.service.impl;

import com.byteacademy.byteacademy.dao.repository.GroupRepository;
import com.byteacademy.byteacademy.exception.EntityExistException;
import com.byteacademy.byteacademy.exception.EntityNotFoundException;
import com.byteacademy.byteacademy.mapper.GroupMapper;
import com.byteacademy.byteacademy.model.group.request.RegisterGroupDTO;
import com.byteacademy.byteacademy.model.group.response.ResponseGroupDTO;
import com.byteacademy.byteacademy.service.interfaces.GroupService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GroupServiceImpl implements GroupService {
    private final GroupRepository repository;
    private final GroupMapper mapper;

    @Override
    public Page<ResponseGroupDTO> getAllGroups(Pageable pageable) {
        return repository.findAll(pageable).map(mapper::mapToDTO);
    }

    @Override
    public ResponseGroupDTO getByGroupNumber(Long number) {
        var group = repository.findByNumber(number).orElseThrow(
                () -> new EntityNotFoundException("GROUP_NOT_FOUND")
        );

        return mapper.mapToDTO(group);
    }

    @Override
    public ResponseGroupDTO getById(Long id) {
        var group = repository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("GROUP_NOT_FOUND")
        );

        return mapper.mapToDTO(group);
    }

    @Override
    public void add(RegisterGroupDTO registerGroupDTO) {
        var check = repository.existsByNumber(registerGroupDTO.getNumber());
        if (check){
            throw new EntityExistException("GROUP_NUMBER_EXISTS");
        }else{
            repository.save(mapper.mapToEntity(registerGroupDTO));
        }
    }

    @Override
    public void update(Long id, RegisterGroupDTO registerGroupDTO) {
        var group = repository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("GROUP_NOT_FOUND")
        );

        repository.save(mapper.mapToUpdateEntity(group, registerGroupDTO));
    }

    @Override
    public void delete(Long id) {
        var check = repository.existsById(id);
        if (check){
            repository.deleteById(id);
        }else{
            throw new EntityNotFoundException("GROUP_NOT_FOUND");
        }
    }
}
