package com.project.okane.controller;

import com.project.okane.entity.User;
import com.project.okane.model.request.RegistrationRequest;
import com.project.okane.repository.UserRepository;
import com.project.okane.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class RegistrationController {

    private final UserService userService;
    private final PasswordEncoder passwordEncoder;

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody RegistrationRequest registrationRequest) {
        if (userService.existsByEmail(registrationRequest.getEmail())) {
            return ResponseEntity.badRequest().body("Email already exists");
        }

        String encodedPassword = passwordEncoder.encode(registrationRequest.getPassword());

        User user = new User();
        user.setEmail(registrationRequest.getEmail());
        user.setPassword(encodedPassword);
        userService.save(user);

        return ResponseEntity.ok("User registered successfully");
    }
}