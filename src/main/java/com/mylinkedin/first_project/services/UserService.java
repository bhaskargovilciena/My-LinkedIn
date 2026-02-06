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
        User currentUser = null;
        try {
            currentUser = userRepository.save(user);
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
        return currentUser;
    }

    public User updateUser(String username, User user) throws UserNotFoundException {
        User newUser = user;
        User oldUser = userRepository.findUserByUsername(username);
        if(oldUser == null) throw new UserNotFoundException(username);
        userRepository.delete(oldUser);
        newUser = userRepository.save(newUser);
        return newUser;
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
