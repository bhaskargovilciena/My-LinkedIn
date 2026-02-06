package com.mylinkedin.first_project.exceptions;

public class CompanyNotFoundException extends Exception{
    public CompanyNotFoundException(String name) {
        super("could not find company with name: " + name);
    }
}
