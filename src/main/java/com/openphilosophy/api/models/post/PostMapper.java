package com.openphilosophy.api.models.post;

import org.springframework.stereotype.Component;

@Component
public class PostMapper {

    // TODO: mapper for registering
    public Post map(PostRegisterDTO data) {
        Post post = new Post();
        return post;
    }
    // TODO: mapper for update
}
