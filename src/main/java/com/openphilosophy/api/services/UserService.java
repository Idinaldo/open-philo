package com.openphilosophy.api.services;

import java.util.List;
import java.util.UUID;

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

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User getById(String id) {
        UUID userId = UUID.fromString(id);
        return userRepository.findById(userId).orElse(null);
    }

    public User register(UserRegisterDTO user) {
        User newUser = userMapper.map(user);
        return userRepository.save(newUser);
    }

    public User update(String id, UserUpdateDTO data) {
        User oldUser = this.getById(id);
        User user = userMapper.map(oldUser, data);
        return userRepository.save(user);
    }

    // TODO: implement delete (by ID) method
}
