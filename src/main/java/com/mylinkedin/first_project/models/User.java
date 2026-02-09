package com.mylinkedin.first_project.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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
    private Company company;
    @Relationship(type = "CREATED", direction = Relationship.Direction.OUTGOING)
    private List<Post> post = new ArrayList<>();
    @JsonIgnore
    @Relationship(type = "FOLLOWS", direction = Relationship.Direction.OUTGOING)
    private List<User> follows = new ArrayList<>();
}
