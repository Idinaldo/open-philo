package com.openphilosophy.api.models.post;

import com.openphilosophy.api.models.game.Game;
import com.openphilosophy.api.models.movie.Movie;
import com.openphilosophy.api.models.user.User;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "app_posts")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private Game[] game;
    private Movie[] movie;

    private String[] tags;
    private String title;

    @NotBlank
    @Column(nullable = false)
    private String content;

    @NotNull
    @Column(nullable = false)
    private User author;

    @ElementCollection
    private PostReaction[] reactions;
    @ElementCollection
    private Post[] comments;

    @CreationTimestamp
    private LocalDate createdAt;
    @UpdateTimestamp
    private LocalDate updatedAt;
}
