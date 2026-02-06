package com.mylinkedin.first_project.controllers;

import com.mylinkedin.first_project.exceptions.CompanyNotFoundException;
import com.mylinkedin.first_project.models.Company;
import com.mylinkedin.first_project.services.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/company")
@Controller
public class CompanyController {
    private final CompanyService companyService;

    @Autowired
    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @PostMapping("/")
    public ResponseEntity<Company> createCompany(@RequestBody Company company) {
        return new ResponseEntity<>(companyService.createCompany(company), HttpStatus.OK);
    }

    @GetMapping("/{companyName}")
    public ResponseEntity<Company> getCompany(@PathVariable String companyName) throws CompanyNotFoundException {
        return new ResponseEntity<>(companyService.getCompany(companyName), HttpStatus.OK);
    }

    @PutMapping("/{companyName}")
    public ResponseEntity<Company> updateCompany(@RequestBody Company company, @PathVariable String companyName) throws CompanyNotFoundException {
        return new ResponseEntity<>(companyService.updateCompany(companyName, company), HttpStatus.OK);
    }

    @DeleteMapping("/{companyName}")
    public ResponseEntity<Boolean> deleteCompany(@PathVariable String companyName) throws CompanyNotFoundException {
        return new ResponseEntity<>(companyService.deleteCompany(companyName), HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Company>> getAllCompanies() {
        return new ResponseEntity<>(companyService.getAllCompanies(), HttpStatus.OK);
    }
}
