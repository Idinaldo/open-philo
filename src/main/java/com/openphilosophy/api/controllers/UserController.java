package com.openphilosophy.api.controllers;

import jakarta.validation.Valid;
import com.openphilosophy.api.models.user.UserUpdateDTO;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.openphilosophy.api.services.UserService;
import com.openphilosophy.api.models.user.UserRegisterDTO;

@RestController
@RequestMapping("api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
         this.userService = userService;
    }

    @PostMapping("/")
    public ResponseEntity<?> register(@RequestBody @Valid UserRegisterDTO user) {
        return userService.register(user);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getMyData(@PathVariable String id) {
        return ResponseEntity.ok(userService.getById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable String id, @RequestBody UserUpdateDTO data) {
        return userService.update(id, data);
    }
}
