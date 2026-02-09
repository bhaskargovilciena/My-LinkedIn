package com.mylinkedin.first_project.models;

import com.mylinkedin.first_project.relationships.WorksAt;
import lombok.Data;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;

import java.time.LocalDate;

@Node
@Data
public class User {
    @Id @GeneratedValue
    private Long id;
    private String name;
    private String username;
    private String password;
    private LocalDate dateOfBirth;
    private String bio;
    private String profileStatus;
    @Relationship(type = "WORKS_AT", direction = Relationship.Direction.OUTGOING)
    private WorksAt company;
}
