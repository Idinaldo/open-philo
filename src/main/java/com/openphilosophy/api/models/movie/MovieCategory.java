package com.openphilosophy.api.models.movie;

public enum MovieCategory {
    SUSPENSE("Suspense/Ação"),
    ACTION("Action/Ação"),
    HORROR("Horror/Horror"),
    TERROR("Terror/Terror"),
    DRAMA("Drama/Drama"),
    ROMANCE("Romance/Romance"),
    COMEDY("Comedy/Comédia"),
    DOCUMENTARY("Documentary/Documentário"),
    FANTASY("Fantasy/Fantasia"),
    SCIFI("Scientific Fiction/Ficção Científica");

    private String description;

    private MovieCategory(String description) {
        this.description = description;
    }
}
