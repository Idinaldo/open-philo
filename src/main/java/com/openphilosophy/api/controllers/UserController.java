package com.openphilosophy.api.controllers;

import com.openphilosophy.api.models.user.User;
import jakarta.validation.Valid;
import com.openphilosophy.api.models.user.UserUpdateDTO;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.openphilosophy.api.services.UserService;
import com.openphilosophy.api.models.user.UserRegisterDTO;

import java.util.List;

@RestController
@RequestMapping("api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
         this.userService = userService;
    }

    @PostMapping("/")
    public ResponseEntity<User> create(@RequestBody @Valid UserRegisterDTO user) {
        return ResponseEntity.ok(userService.register(user));
    }

    @GetMapping("/")
    public ResponseEntity<List<User>> findAll() {
        return ResponseEntity.ok(userService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getById(@PathVariable String id) {
        return ResponseEntity.ok(userService.getById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> updateById(@PathVariable String id, @RequestBody UserUpdateDTO data) {
        return ResponseEntity.ok(userService.update(id, data));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteById(@PathVariable String id) {
        return ResponseEntity.ok("This endpoint is still under development. We'll release its functional version soon.");
    }
}
