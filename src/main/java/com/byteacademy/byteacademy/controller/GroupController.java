package com.byteacademy.byteacademy.controller;

import com.byteacademy.byteacademy.model.GroupDTO;
import com.byteacademy.byteacademy.service.interfaces.GroupService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/groups")
public class GroupController {
    private final GroupService service;

    @GetMapping
    public Page<GroupDTO> getAll(Pageable pageable, HttpServletRequest request){
        return service.getAllGroups(pageable, request);
    }

    @GetMapping("/number/{number}")
    public GroupDTO getByGroupNumber(@PathVariable Long number, HttpServletRequest request){
        return service.getByGroupNumber(number, request);
    }

    @GetMapping("/id/{id}")
    public GroupDTO getById(@PathVariable Long id, HttpServletRequest request){
        return service.getById(id, request);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public GroupDTO add(@RequestBody @Valid GroupDTO registerGroupDTO, HttpServletRequest request){
        return service.add(registerGroupDTO,request);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable Long id, @RequestBody GroupDTO registerGroupDTO, HttpServletRequest request){
        service.update(id, registerGroupDTO,request);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id, HttpServletRequest request){
        service.delete(id, request);
    }
}
