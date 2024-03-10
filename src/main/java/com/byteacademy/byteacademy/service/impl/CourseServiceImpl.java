package com.byteacademy.byteacademy.service.impl;

import com.byteacademy.byteacademy.dao.repository.CourseRepository;
import com.byteacademy.byteacademy.exception.EntityExistException;
import com.byteacademy.byteacademy.exception.EntityNotFoundException;
import com.byteacademy.byteacademy.mapper.CourseMapper;
import com.byteacademy.byteacademy.model.course.request.CourseDTO;
import com.byteacademy.byteacademy.model.course.response.ClientCourseFullDTO;
import com.byteacademy.byteacademy.model.course.response.ClientCourseListDTO;
import com.byteacademy.byteacademy.service.interfaces.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CourseServiceImpl implements CourseService {

    private final CourseRepository repository;
    private final CourseMapper mapper;
    @Override
    public Page<ClientCourseListDTO> getAllList(Pageable pageable) {
        return repository.findAll(pageable).map(mapper::mapToListDTO);
    }

    @Override
    public ClientCourseFullDTO getCourseBySlug(String slug) {
        var course = repository.findBySlug(slug).orElseThrow(
                () -> new EntityNotFoundException("COURSE_NOT_FOUND")
        );

        return mapper.mapToFullDTO(course);
    }

    @Override
    public void add(CourseDTO courseDTO) {
        var course = repository.findBySlug(courseDTO.getSlug());

        if (course.isPresent()){
            throw new EntityExistException("COURSE_WITH_THIS_SLUG_ALREADY_EXIST");
        }else {
            repository.save(mapper.mapToEntity(courseDTO));
        }
    }

    @Override
    public void update(Long id, CourseDTO courseDTO) {
        var exist = repository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("COURSE_NOT_FOUND")
        );

        repository.save(mapper.mapUpdateDtoToEntity(exist, courseDTO));
    }

    @Override
    public void delete(Long id) {
        var course = repository.existsById(id);
        if (course){
            repository.deleteById(id);
        }else{
            throw new EntityNotFoundException("COURSE_NOT_FOUND");
        }
    }
}
