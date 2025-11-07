package com.openphilosophy.api.services;

import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.openphilosophy.api.models.user.User;
import com.openphilosophy.api.models.user.UserMapper;
import com.openphilosophy.api.models.user.UserUpdateDTO;
import com.openphilosophy.api.models.user.UserRegisterDTO;
import com.openphilosophy.api.repositories.UserRepository;

@Service
public class UserService {

    private final UserMapper userMapper;
    private final UserRepository userRepository;

    public UserService(UserMapper userMapper, UserRepository userRepository) {
        this.userMapper = userMapper;
        this.userRepository = userRepository;
    }

    public User getById(String id) {
        UUID userId = UUID.fromString(id);
        return userRepository.findById(userId).orElse(null);
    }

    public ResponseEntity<?> register(UserRegisterDTO user) {
        User newUser = userMapper.map(user);
        return ResponseEntity.ok(userRepository.save(newUser));
    }

    public ResponseEntity<?> update(String id, UserUpdateDTO data) {
        User oldUser = this.getById(id);
        User user = userMapper.map(oldUser, data);
        return ResponseEntity.ok(userRepository.save(user));
    }
}
