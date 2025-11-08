package com.openphilosophy.api.models.post;

import org.springframework.stereotype.Component;

@Component
public class PostMapper {

    public Post map(PostRegisterDTO data) {
        Post post = new Post();

        post.setContent(data.content());
        post.setAuthor(data.author());

        if (data.game() != null) post.setGame(data.game());
        if (data.movie() != null) post.setMovie(data.movie());
        if (data.tags() != null) post.setTags(data.tags());
        if (data.title() != null) post.setTitle(data.title());

        return post;
    }

    public Post map(Post post, PostUpdateDTO data) {

        if (data.game() != null) post.setGame(data.game());
        if (data.movie() != null) post.setMovie(data.movie());
        if (data.tags() != null) post.setTags(data.tags());
        if (data.title() != null) post.setTitle(data.title());
        if (data.content() != null) post.setContent(data.content());
        if (data.author() != null) post.setAuthor(data.author());
        if (data.reactions() != null) post.setReactions(data.reactions());
        if (data.comments() != null) post.setComments(data.comments());
        return post;
    };
}
