package com.byteacademy.byteacademy.service.interfaces;

import com.byteacademy.byteacademy.model.course.request.CourseDTO;
import com.byteacademy.byteacademy.model.course.response.ClientCourseFullDTO;
import com.byteacademy.byteacademy.model.course.response.ClientCourseListDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CourseService {
    Page<ClientCourseListDTO> getAllList(Pageable pageable);
    ClientCourseFullDTO getCourseBySlug(String slug);
    void add(CourseDTO courseDTO);
    void update(Long id, CourseDTO courseDTO);
    void delete(Long id);

}
