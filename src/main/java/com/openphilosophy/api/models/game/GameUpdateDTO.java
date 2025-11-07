package com.openphilosophy.api.models.game;

import java.time.LocalDate;

public record GameUpdateDTO(String title, String developer, LocalDate release, String synopsis, String[] category) {
}
