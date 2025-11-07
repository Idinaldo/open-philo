package com.openphilosophy.api.models.movie;

import java.time.LocalDate;

public record MovieUpdateDTO(String title, String producer, LocalDate release, String[] category, String[] castActors, String synopsis) {
}
