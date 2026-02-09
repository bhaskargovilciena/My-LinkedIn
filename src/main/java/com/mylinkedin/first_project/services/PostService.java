package com.mylinkedin.first_project.services;

import com.mylinkedin.first_project.exceptions.PostNotFoundException;
import com.mylinkedin.first_project.models.Post;
import com.mylinkedin.first_project.repositories.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {
    private final PostRepository repository;

    @Autowired
    public PostService(PostRepository repository) {
        this.repository = repository;
    }

    public Post getPost(String id) throws PostNotFoundException {
        Optional<Post> post = repository.findById(id);
        if(post.isEmpty()) throw new PostNotFoundException(id);
        return post.get();
    }

    public Post updatePost(String id, Post newPost) throws PostNotFoundException {
        if(repository.findById(id).isEmpty()) throw new PostNotFoundException(id);
        repository.deleteById(id);
        repository.save(newPost);
        return newPost;
    }

    public boolean deletePost(String id) throws PostNotFoundException {
        if(repository.findById(id).isEmpty()) throw new PostNotFoundException(id);
        repository.deleteById(id);
        return true;
    }

    public Post createPost(Post post) {
        return repository.save(post);
    }

    public List<Post> getAllPosts() {
        return repository.findAll();
    }
}
