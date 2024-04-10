package com.byteacademy.byteacademy.controller;

import com.byteacademy.byteacademy.model.CourseDTO;
import com.byteacademy.byteacademy.model.RequestUpdateTeacherDTO;
import com.byteacademy.byteacademy.model.TeacherDTO;
import com.byteacademy.byteacademy.service.interfaces.CourseService;
import com.byteacademy.byteacademy.service.interfaces.TeacherService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/teachers")
@RequiredArgsConstructor
public class TeacherController {
    private final TeacherService teacherService;
    private final CourseService courseService;

    @GetMapping
    public Page<TeacherDTO> getAllList(Pageable pageable){
        return teacherService.getAllList(pageable);
    }

    @GetMapping("/{username}")
    public TeacherDTO getByUsername(@PathVariable String username){
        return teacherService.getByUsername(username);
    }

    @GetMapping("/courses/teacherId/{id}")
    public List<CourseDTO> getCoursesByTeacherId(@PathVariable Long id){
        return courseService.getByTeacherId(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public TeacherDTO add(@RequestBody @Valid TeacherDTO registerTeacherDTO, HttpServletRequest request){
        return teacherService.add(registerTeacherDTO, request);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable Long id, @RequestBody RequestUpdateTeacherDTO updateTeacherDTO, HttpServletRequest request){
        teacherService.update(id, updateTeacherDTO, request);
    }
}
