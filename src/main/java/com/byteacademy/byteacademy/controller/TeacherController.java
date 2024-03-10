package com.byteacademy.byteacademy.controller;

import com.byteacademy.byteacademy.model.teacher.request.RegisterTeacherDTO;
import com.byteacademy.byteacademy.model.teacher.request.UpdateTeacherDTO;
import com.byteacademy.byteacademy.model.teacher.response.DetailedTeacherDTO;
import com.byteacademy.byteacademy.model.teacher.response.MiniTeacherDTO;
import com.byteacademy.byteacademy.service.interfaces.TeacherService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("${root.url}/teacher")
@RequiredArgsConstructor
public class TeacherController {
    private final TeacherService teacherService;

    @GetMapping
    public Page<MiniTeacherDTO> getAllList(Pageable pageable){
        return teacherService.getAllList(pageable);
    }

    @GetMapping("/{username}")
    public DetailedTeacherDTO getByUsername(@PathVariable String username){
        return teacherService.getByUsername(username);
    }

    @PostMapping
    public void add(@RequestBody @Valid RegisterTeacherDTO registerTeacherDTO){
        teacherService.add(registerTeacherDTO);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void update(@PathVariable Long id, @RequestBody UpdateTeacherDTO updateTeacherDTO){
        teacherService.update(id, updateTeacherDTO);
    }
}
