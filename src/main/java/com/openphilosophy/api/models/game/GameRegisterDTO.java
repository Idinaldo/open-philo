package com.openphilosophy.api.models.game;

import jakarta.validation.constraints.NotBlank;
import java.time.LocalDate;

public record GameRegisterDTO(@NotBlank String title, String[] category, LocalDate release, String synopsis, String developer) {
}
