package com.byteacademy.byteacademy.controller.auth;

import com.byteacademy.byteacademy.model.auth.AuthRequestDTO;
import com.byteacademy.byteacademy.model.auth.AuthenticationDTO;
import com.byteacademy.byteacademy.service.auth.AuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/auth")
public class AuthController {
    private final AuthService authService;

    @PostMapping("/login")
    public AuthenticationDTO login(@RequestBody @Valid AuthRequestDTO authRequestDto) {
        return authService.authenticate(authRequestDto);
    }

    @DeleteMapping("/delete/{username}")
    public void delete(@PathVariable String username){
        authService.deleteUser(username);
    }

    @DeleteMapping("/enable/{username}")
    public void enable(@PathVariable String username){
        authService.enableUser(username);
    }

}
