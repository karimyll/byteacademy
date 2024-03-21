package com.byteacademy.byteacademy.controller;

import com.byteacademy.byteacademy.model.group.request.RegisterGroupDTO;
import com.byteacademy.byteacademy.model.group.response.ResponseGroupDTO;
import com.byteacademy.byteacademy.service.interfaces.GroupService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/group")
public class GroupController {
    private final GroupService service;

    @GetMapping
    public Page<ResponseGroupDTO> getAllGroups(Pageable pageable){
        return service.getAllGroups(pageable);
    }

    @GetMapping("/number/{number}")
    public ResponseGroupDTO getByGroupNumber(@PathVariable Long number){
        return service.getByGroupNumber(number);
    }

    @GetMapping("/id/{id}")
    public ResponseGroupDTO getById(@PathVariable Long id){
        return service.getById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void add(@RequestBody @Valid RegisterGroupDTO registerGroupDTO){
        service.add(registerGroupDTO);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable Long id, @RequestBody RegisterGroupDTO registerGroupDTO){
        service.update(id, registerGroupDTO);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id){
        service.delete(id);
    }
}
