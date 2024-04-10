package com.byteacademy.byteacademy.service.impl;

import com.byteacademy.byteacademy.dao.repository.CourseRepository;
import com.byteacademy.byteacademy.exception.EntityNotFoundException;
import com.byteacademy.byteacademy.mapper.CourseMapper;
import com.byteacademy.byteacademy.model.CourseDTO;
import com.byteacademy.byteacademy.service.interfaces.CourseService;
import com.byteacademy.byteacademy.utility.ExtractorHelper;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class CourseServiceImpl implements CourseService {

    private final CourseRepository repository;
    private final CourseMapper mapper;
    private final ExtractorHelper extractorHelper;

    public String username(HttpServletRequest request) {
        return extractorHelper.extractUsername(request);
    }

    @Override
    public Page<CourseDTO> getAllList(Pageable pageable) {
        log.info("Getting all courses");
        return repository.findAll(pageable).map(mapper::mapToListDTO);
    }

    @Override
    public CourseDTO getBySlug(String slug) {
        log.info("Getting course by slug {}", slug);
        var course = repository.findBySlug(slug).orElseThrow(
                () -> new EntityNotFoundException("COURSE_NOT_FOUND")
        );

        return mapper.mapToFullDTO(course);
    }

    @Override
    public List<CourseDTO> getByTeacherId(Long teacherId) {
        log.info("Getting course by teacher id {}", teacherId);
        var courses = repository.findByTeacherId(teacherId);
        return courses.stream()
                .map(mapper::mapToListDTO)
                .toList();
    }


    @Override
    public CourseDTO add(CourseDTO courseDTO, HttpServletRequest request) {
        log.info("Course add service started by username: {}", username(request));
        repository.save(mapper.mapToEntity(courseDTO));
        log.info("Course add service finished by username: {}", username(request));
        return courseDTO;
    }

    @Override
    public void update(Long id, CourseDTO courseDTO, HttpServletRequest request) {
        log.info("Course update service started by username: {}, id: {}", username(request), id);
        var exist = repository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("COURSE_NOT_FOUND")
        );

        repository.save(mapper.mapUpdateDtoToEntity(exist, courseDTO));

        log.info("Course update service finished by username: {}", username(request));
    }

    @Override
    public void delete(Long id, HttpServletRequest request) {
        log.info("Course delete service started by username: {}, id: {}", username(request), id);
        repository.deleteById(id);
        log.info("Course delete service finished by username: {}, id: {}", username(request), id);
    }
}
