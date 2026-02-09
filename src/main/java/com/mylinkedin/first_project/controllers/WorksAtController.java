package com.mylinkedin.first_project.controllers;

import com.mylinkedin.first_project.exceptions.CompanyNotFoundException;
import com.mylinkedin.first_project.exceptions.UserNotFoundException;
import com.mylinkedin.first_project.models.User;
import com.mylinkedin.first_project.services.WorksAtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/works-at")
public class WorksAtController {
    private final WorksAtService service;

    @Autowired
    public WorksAtController(WorksAtService service) {
        this.service = service;
    }

    @PostMapping("/{username}/{companyName}")
    public ResponseEntity<User> setWorksAt(@PathVariable String username, @PathVariable String companyName) throws UserNotFoundException, CompanyNotFoundException {
        return new ResponseEntity<>(service.setWorksAt(username, companyName), HttpStatus.OK);
    }
}
