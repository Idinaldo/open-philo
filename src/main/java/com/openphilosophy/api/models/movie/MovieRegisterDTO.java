package com.openphilosophy.api.models.movie;

import jakarta.validation.constraints.NotBlank;

import java.time.LocalDate;

public record MovieRegisterDTO(@NotBlank String title, String producer, String[] category, LocalDate release, String[] castActors, String synopsis) {
}
