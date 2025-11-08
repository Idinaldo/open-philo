package com.openphilosophy.api.services;

import com.openphilosophy.api.models.post.Post;
import com.openphilosophy.api.models.post.PostMapper;
import com.openphilosophy.api.models.post.PostRegisterDTO;
import com.openphilosophy.api.models.post.PostUpdateDTO;
import com.openphilosophy.api.repositories.PostRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import java.util.List;
import java.util.UUID;

// TODO: refactor methods to include try-catch logic
@Service
public class PostService {

    private final Logger logger;
    private final PostMapper postMapper;
    private final PostRepository postRepository;
    private final String UNEXPECTED_ERROR_MSG = "There was an unexpected error. Please review your data and try again.";


    public PostService(PostMapper postMapper, PostRepository postRepository) {
        this.postMapper = postMapper;
        this.postRepository = postRepository;
        this.logger = LoggerFactory.getLogger(PostService.class);
    }

    // create (C)
    public Post create(PostRegisterDTO data) throws ResponseStatusException {
        Post post;
        try {
            post = postMapper.map(data);
        } catch (Exception e) {
            logger.error("There was an unexpected error while trying to create this post.");
            logger.error("INFO: ", e.getCause());
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "There was an error. Please review your data.");
        }
        return postRepository.save(post);
    }

    // findAll (R)
    public List<Post> findAll() {
        return postRepository.findAll();
    }

    // findByid (R)
    public Post findById(String id) throws ResponseStatusException {
        UUID uuidPost;
        try {
            uuidPost = UUID.fromString(id);
        } catch (Exception e) {
            logger.error("There was an error while trying to convert String (id) to UUID (uuid)");
            logger.error("INFO: ", e.getCause());
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, UNEXPECTED_ERROR_MSG);
        }
        return postRepository.findById(uuidPost).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Post not found."));
    }

    // TODO: implement update (put, U)
    public Post updateById(String id, PostUpdateDTO data) {
        UUID uuidPost;
        try {
            uuidPost = UUID.fromString(id);
        } catch (Exception e) {
            logger.error("There was an error while trying to parse String (id) to UUID (uuid).");
            logger.error("INFO: ", e.getCause());
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "There was an unexpected error while trying to update this post. Review your request and try again.");
        }
        Post oldPost = postRepository.findById(uuidPost).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Post not found."));
        Post post = postMapper.map(oldPost, data);
        return postRepository.save(post);
    }
    // TODO: implement delete (D)
}
