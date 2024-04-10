package com.byteacademy.byteacademy.controller;

import com.byteacademy.byteacademy.model.CourseDTO;
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
@RequestMapping("/api/v1/courses")
@RequiredArgsConstructor
public class CourseController {
    private final CourseService courseService;
    private final TeacherService teacherService;

    @GetMapping
    public Page<CourseDTO> getAllList(Pageable pageable){
        return courseService.getAllList(pageable);
    }

    @GetMapping("/{slug}")
    public CourseDTO getBySlug(@PathVariable String slug){
        return courseService.getBySlug(slug);
    }

    @GetMapping("/teachers/teacherId/{id}")
    public List<TeacherDTO> getByCourseId(@PathVariable Long id){
        return teacherService.getByCourseId(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CourseDTO add(@RequestBody @Valid CourseDTO courseDTO, HttpServletRequest request){
        return courseService.add(courseDTO, request);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable Long id, @RequestBody CourseDTO courseDTO, HttpServletRequest request){
        courseService.update(id, courseDTO, request);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id, HttpServletRequest request){
        courseService.delete(id, request);
    }
}
