package com.openphilosophy.api.controllers;

import com.openphilosophy.api.models.post.Post;
import com.openphilosophy.api.models.post.PostRegisterDTO;
import com.openphilosophy.api.models.post.PostUpdateDTO;
import com.openphilosophy.api.services.PostService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/posts")
public class PostController {

    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    // create (C)
    @PostMapping("/")
    public ResponseEntity<Post> create(@RequestBody @Valid PostRegisterDTO data) {
        return ResponseEntity.ok(postService.create(data));
    }

    // findAll (R)
    @GetMapping("/")
    public ResponseEntity<List<Post>> findAll() {
        return ResponseEntity.ok(postService.findAll());
    }

    // findById (R)
    @GetMapping("/{id}")
    public ResponseEntity<Post> findById(@PathVariable String id) {
        return ResponseEntity.ok(postService.findById(id));
    }

    // TODO: implement update (put, U)
    @PutMapping("/{id}")
    public ResponseEntity<Post> updateById(@PathVariable String id, @RequestBody PostUpdateDTO data) {
        return ResponseEntity.ok(postService.updateById(id, data));
    }

    // TODO: implement delete (D)
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteById(@PathVariable String id) {
        return ResponseEntity.ok(id);
    }
}
