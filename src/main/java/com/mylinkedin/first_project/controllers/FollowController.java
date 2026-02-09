package com.mylinkedin.first_project.controllers;

import com.mylinkedin.first_project.exceptions.UserNotFoundException;
import com.mylinkedin.first_project.models.User;
import com.mylinkedin.first_project.services.FollowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/follow")
public class FollowController {
    private final FollowService followService;

    @Autowired
    public FollowController(FollowService followService) {
        this.followService = followService;
    }

    @PutMapping("/{username1}/{username2}")
    public ResponseEntity<User> addFollower(@PathVariable String username1, @PathVariable String username2) throws UserNotFoundException {
        return new ResponseEntity<>(followService.followUser(username1, username2), HttpStatus.OK);
    }

    @GetMapping("/{username}/all")
    public ResponseEntity<List<User>> getAllFollowers(@PathVariable String username) throws UserNotFoundException {
        return new ResponseEntity<>(followService.getAllFollowers(username), HttpStatus.OK);
    }

    @DeleteMapping("/{username1}/{username2}")
    public ResponseEntity<User> unfollowUser(@PathVariable String username1, @PathVariable String username2) throws UserNotFoundException {
        return new ResponseEntity<>(followService.unfollowUser(username1, username2), HttpStatus.OK);
    }
}
