package com.openphilosophy.api.models.user;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record UserRegisterDTO(@NotBlank String name, @NotBlank @Email String email, @NotBlank String password, @NotNull UserRole[] role, String bio) {
}
