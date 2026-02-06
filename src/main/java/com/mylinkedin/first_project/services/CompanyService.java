package com.mylinkedin.first_project.services;

import com.mylinkedin.first_project.exceptions.CompanyNotFoundException;
import com.mylinkedin.first_project.models.Company;
import com.mylinkedin.first_project.repositories.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyService {
    private final CompanyRepository companyRepository;

    @Autowired
    public CompanyService(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    public Company createCompany(Company company) {
        return companyRepository.save(company);
    }

    public Company getCompany(String name) throws CompanyNotFoundException {
        Company company =  companyRepository.findCompaniesByName(name);
        if(company == null) throw new CompanyNotFoundException(name);
        return company;
    }

    public Company updateCompany(String companyName, Company newCompany) throws CompanyNotFoundException {
        Company oldCompany = companyRepository.findCompaniesByName(companyName);
        if(oldCompany == null) throw new CompanyNotFoundException(companyName);
        companyRepository.delete(oldCompany);
        return companyRepository.save(newCompany);
    }

    public boolean deleteCompany(String companyName) throws CompanyNotFoundException {
        Company company = companyRepository.findCompaniesByName(companyName);
        if(company == null) throw new CompanyNotFoundException(companyName);
        companyRepository.delete(company);
        return true;
    }

    public List<Company> getAllCompanies() {
        return companyRepository.findAll();
    }
}
