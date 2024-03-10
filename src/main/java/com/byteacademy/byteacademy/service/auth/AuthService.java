package com.byteacademy.byteacademy.service.auth;

import com.byteacademy.byteacademy.dao.entity.UserEntity;
import com.byteacademy.byteacademy.dao.repository.UserRepository;
import com.byteacademy.byteacademy.exception.EntityNotFoundException;
import com.byteacademy.byteacademy.mapper.UserMapper;
import com.byteacademy.byteacademy.model.auth.AuthRequestDTO;
import com.byteacademy.byteacademy.model.auth.AuthenticationDTO;
import com.byteacademy.byteacademy.model.auth.RoleDTO;
import com.byteacademy.byteacademy.model.auth.UserRegisterDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@RequiredArgsConstructor
@Slf4j
public class AuthService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authManager;
    private final UserMapper userMapper;

    public void register(String username, String password, Set<RoleDTO> roles) {
        var user = UserRegisterDTO.builder()
                .username(username)
                .password(passwordEncoder.encode(password))
                .roles(roles)
                .isEnabled(true)
                .build();

        userRepository.save(userMapper.mapRegisterToEntity(user));
    }

    public AuthenticationDTO authenticate(AuthRequestDTO authRequestDTO) {
        log.info("ActionLog.authenticate.start by: {}", authRequestDTO.getUsername());

        UserEntity user = userRepository.findUserByUsername(authRequestDTO.getUsername())
                .orElseThrow(
                        () -> new BadCredentialsException("INVALID_USERNAME_OR_PASSWORD")
                );

        try {

            authManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            authRequestDTO.getUsername(),
                            authRequestDTO.getPassword()
                    )
            );

            var jwtToken = jwtService.generateToken(user);
            log.info("ActionLog.authenticate.end logged in: {}",  user.getUsername());
            return AuthenticationDTO.builder().token(jwtToken).build();
        } catch (BadCredentialsException e){
            log.error("Error due to {} ", e.getMessage());
            throw new BadCredentialsException("INVALID_USERNAME_OR_PASSWORD");
        }
    }

    public void deleteUser(String username) {
        log.info("ActionLog.deleteUser.start");
        var user = userRepository.findUserByUsername(username).orElseThrow(
                () -> new EntityNotFoundException("TEACHER_NOT_FOUND")
        );
        user.setIsEnabled(false);
        userRepository.save(user);
        log.info("ActionLog.deleteUser.end");
    }

    public void enableUser(String username) {
        log.info("ActionLog.enableUser.start");
        var user = userRepository.findUserByUsername(username).orElseThrow(
                () -> new EntityNotFoundException("TEACHER_NOT_FOUND")
        );
        user.setIsEnabled(true);
        userRepository.save(user);
        log.info("ActionLog.enableUser.end");
    }

}

