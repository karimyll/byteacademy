package com.byteacademy.byteacademy.utility;

import com.byteacademy.byteacademy.service.auth.JwtService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;

@RequiredArgsConstructor
@Configuration
public class ExtractorHelper {
    private final JwtService jwtService;

    public String extractUsername(HttpServletRequest request) {
        String token = request.getHeader("Authorization").substring(7);

        return jwtService.extractUsername(token);
    }
}
