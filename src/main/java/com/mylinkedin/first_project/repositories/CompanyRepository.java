package com.mylinkedin.first_project.repositories;

import com.mylinkedin.first_project.models.Company;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRepository extends Neo4jRepository<Company, Long> {
    Company findCompaniesByName(String name);
}
