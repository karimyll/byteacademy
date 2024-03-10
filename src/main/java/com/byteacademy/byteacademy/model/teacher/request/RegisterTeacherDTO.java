package com.byteacademy.byteacademy.model.teacher.request;

import com.byteacademy.byteacademy.model.auth.RoleDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegisterTeacherDTO {
    private String name;
    private String surname;
    private String username;
    private String password;
    private String imageUrl;
    private String job;
    private String about;
    private List<Long> courseId;
    private Set<RoleDTO> roles;
}
