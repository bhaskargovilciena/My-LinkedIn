package com.mylinkedin.first_project.repositories;

import com.mylinkedin.first_project.models.User;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends Neo4jRepository<User, Long> {
    User findUserByUsername(String username);
}
