package com.mylinkedin.first_project.services;

import com.mylinkedin.first_project.exceptions.UserNotFoundException;
import com.mylinkedin.first_project.models.User;
import com.mylinkedin.first_project.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public User updateUser(String username, User updatedUser) throws UserNotFoundException {
        User user = userRepository.findUserByUsername(username);
        if(user == null) throw new UserNotFoundException(username);
        System.out.println("old user" + user);
        System.out.println("new user " + updatedUser);
        userRepository.delete(user);
        return userRepository.save(updatedUser);
    }

    public User getUser(String username) throws UserNotFoundException {
        User user = userRepository.findUserByUsername(username);
        if(user == null) throw new UserNotFoundException(username);
        return user;
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public boolean deleteUser(String username) throws UserNotFoundException {
        User user = userRepository.findUserByUsername(username);
        if(user == null) throw new UserNotFoundException(username);
        userRepository.delete(user);
        return true;
    }
}
