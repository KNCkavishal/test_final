package com.ecotrip.ecotrip_backend.service.impl;

import com.ecotrip.ecotrip_backend.model.SignupRequest;
import com.ecotrip.ecotrip_backend.model.User;
import com.ecotrip.ecotrip_backend.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void register(SignupRequest request) throws Exception {
        if (userRepository.existsByEmail(request.getEmail())) {
            throw new Exception("Email already registered");
        }

        User user = new User();
        user.setName(request.getName());
        user.setEmail(request.getEmail());
        user.setPassword(encoder.encode(request.getPassword()));

        userRepository.save(user);
    }

    public User login(String email, String password) throws Exception {
        User user = userRepository.findByEmail(email);
        if (user == null || !encoder.matches(password, user.getPassword())) {
            throw new Exception("Invalid credentials");
        }
        return user;
    }
}
