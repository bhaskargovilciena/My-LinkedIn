package com.mylinkedin.first_project.controllers;

import com.mylinkedin.first_project.exceptions.PostNotFoundException;
import com.mylinkedin.first_project.exceptions.UserNotFoundException;
import com.mylinkedin.first_project.models.Post;
import com.mylinkedin.first_project.models.User;
import com.mylinkedin.first_project.relationships.Created;
import com.mylinkedin.first_project.services.PostService;
import com.mylinkedin.first_project.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/post")
public class PostController {
    private final PostService service;
    private final UserService userService;

    @Autowired
    public PostController(PostService service, UserService userService) {
        this.service = service;
        this.userService = userService;
    }

    @GetMapping("/{postId}")
    public ResponseEntity<Post> getPost(@PathVariable String postId) throws PostNotFoundException {
        return new ResponseEntity<>(service.getPost(postId), HttpStatus.OK);
    }

    @PostMapping("/{username}")
    public ResponseEntity<Post> createPost(@RequestBody Post post, @PathVariable String username) throws UserNotFoundException {
        User user = userService.getUser(username);
        service.createPost(post);
        user.getPost().add(post);
        userService.updateUser(username, user);
        return new ResponseEntity<>(post, HttpStatus.OK);
    }

    @PutMapping("/{postId}")
    public ResponseEntity<Post> updatePost(@PathVariable String postId, @RequestBody Post post) throws PostNotFoundException {
        return new ResponseEntity<>(service.updatePost(postId, post), HttpStatus.OK);
    }

    @DeleteMapping("/{postId}")
    public ResponseEntity<Boolean> deletePost(@PathVariable String postId) throws PostNotFoundException {
        return new ResponseEntity<>(service.deletePost(postId), HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Post>> getAllPosts() {
        return new ResponseEntity<>(service.getAllPosts(), HttpStatus.OK);
    }
}
