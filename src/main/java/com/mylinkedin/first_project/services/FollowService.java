package com.mylinkedin.first_project.services;

import com.mylinkedin.first_project.exceptions.UserNotFoundException;
import com.mylinkedin.first_project.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FollowService {
    private final UserService userService;

    @Autowired
    public FollowService(UserService userService) {
        this.userService = userService;
    }

    public User followUser(String username1, String username2) throws UserNotFoundException {
        User user1 = userService.getUser(username1);
        User user2 = userService.getUser(username2);
        user1.getFollows().add(user2);
        return userService.updateUser(username1, user1);
    }

    public List<User> getAllFollowers(String username) throws UserNotFoundException {
        User user = userService.getUser(username);
        return user.getFollows();
    }

    public User unfollowUser(String username1, String username2) throws UserNotFoundException {
        User user1 = userService.getUser(username1);
        User user2 = userService.getUser(username2);
        user1.getFollows().remove(user2);
        return userService.updateUser(username1, user1);
    }
}
