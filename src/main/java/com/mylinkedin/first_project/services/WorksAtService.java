package com.mylinkedin.first_project.services;

import com.mylinkedin.first_project.exceptions.CompanyNotFoundException;
import com.mylinkedin.first_project.exceptions.UserNotFoundException;
import com.mylinkedin.first_project.models.Company;
import com.mylinkedin.first_project.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WorksAtService {
    private final UserService userService;
    private final CompanyService companyService;

    @Autowired
    public WorksAtService(UserService userService, CompanyService companyService) {
        this.userService = userService;
        this.companyService = companyService;
    }

    public User setWorksAt(String username, String companyName) throws UserNotFoundException, CompanyNotFoundException {
        User user = userService.getUser(username);
        Company company = companyService.getCompany(companyName);
        user.setCompany(company);
        userService.updateUser(username, user);
        return user;
    }

    public Company getWorksAt(String username) throws UserNotFoundException {
        User user = userService.getUser(username);
        return user.getCompany();
    }
}
