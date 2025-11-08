package com.openphilosophy.api.models.user;

import java.util.Set;

public record UserUpdateDTO(String name, String email, String password, String bio, Set<UserRole> role) {
}
