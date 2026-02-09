package com.mylinkedin.first_project.exceptions;

public class PostNotFoundException extends Exception {
    public PostNotFoundException(String id) {
        super("could not find post with id: " + id);
    }
}
