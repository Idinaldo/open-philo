package com.openphilosophy.api.models.user;

public record UserUpdateDTO(String name, String email, String password, String bio, UserRole[] role) {
}
