package com.mylinkedin.first_project.exceptions;

public class UserNotFoundException extends Exception {
    public UserNotFoundException(String username) {
        super("could not find user with username: " + username);
    }
}
