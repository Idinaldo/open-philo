package com.openphilosophy.api.models.post;

import com.openphilosophy.api.models.game.Game;
import com.openphilosophy.api.models.movie.Movie;
import com.openphilosophy.api.models.user.User;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import java.time.LocalDate;
import java.util.UUID;

@Data
@Entity
@AllArgsConstructor
@RequiredArgsConstructor
@Table(name = "app_posts")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ElementCollection
    private Game[] game;
    @ElementCollection
    private Movie[] movie;

    private String[] tags;
    private String title;

    @NotBlank
    @Column(nullable = false)
    private String content;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
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
