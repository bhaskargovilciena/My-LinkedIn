package com.mylinkedin.first_project.services;

import com.mylinkedin.first_project.exceptions.CompanyNotFoundException;
import com.mylinkedin.first_project.exceptions.UserNotFoundException;
import com.mylinkedin.first_project.models.Company;
import com.mylinkedin.first_project.models.User;
import com.mylinkedin.first_project.relationships.WorksAt;
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

        WorksAt worksAt = new WorksAt();
        worksAt.setCompany(company);
        user.setCompany(worksAt);

        return user;
    }
}
