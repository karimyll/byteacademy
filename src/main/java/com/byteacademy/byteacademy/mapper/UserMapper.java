package com.byteacademy.byteacademy.mapper;

import com.byteacademy.byteacademy.dao.entity.User;
import com.byteacademy.byteacademy.model.auth.UserRegisterDTO;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface UserMapper {
    User mapRegisterToEntity(UserRegisterDTO userRegisterDTO);
}
