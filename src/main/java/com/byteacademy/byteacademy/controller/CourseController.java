package com.byteacademy.byteacademy.controller;

import com.byteacademy.byteacademy.model.course.request.CourseDTO;
import com.byteacademy.byteacademy.model.course.response.ClientCourseFullDTO;
import com.byteacademy.byteacademy.model.course.response.ClientCourseListDTO;
import com.byteacademy.byteacademy.service.interfaces.CourseService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("${root.url}/course")
@RequiredArgsConstructor
public class CourseController {
    private final CourseService courseService;

    @GetMapping
    public Page<ClientCourseListDTO> getAllList(Pageable pageable){
        return courseService.getAllList(pageable);
    }

    @GetMapping("/{slug}")
    public ClientCourseFullDTO getCourseBySlug(@PathVariable String slug){
        return courseService.getCourseBySlug(slug);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void add(@RequestBody @Valid CourseDTO courseDTO){
        courseService.add(courseDTO);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void update(@PathVariable Long id, @RequestBody CourseDTO courseDTO){
        courseService.update(id, courseDTO);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id){
        courseService.delete(id);
    }
}
