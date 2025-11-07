package com.openphilosophy.api.models.game;

import java.util.UUID;
import java.time.LocalDate;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.annotations.CreationTimestamp;

// TODO: add tags and game image
@Data
@Entity
@AllArgsConstructor
@RequiredArgsConstructor
@Table(name = "app_games")
public class Game {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @NotBlank
    private String title;
    @ElementCollection
    private String[] category;

    private String synopsis;
    private LocalDate release;
    private String developer;

    @CreationTimestamp
    private LocalDate createdAt;
    @UpdateTimestamp
    private LocalDate updatedAt;
}
