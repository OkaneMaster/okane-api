package com.project.okane.service;

import com.project.okane.entity.User;
import com.project.okane.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepo;

    public UserService(UserRepository userRepo) {
        this.userRepo = userRepo;
    }

    public boolean existsByEmail(String email) {
        return userRepo.existsByEmail(email);
    }

    public User save(User user) {
        return userRepo.save(user);
    }
}
