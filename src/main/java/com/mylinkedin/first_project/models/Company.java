package com.mylinkedin.first_project.models;

import lombok.Data;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;

import java.time.LocalDate;

@Node
@Data
public class Company {
    @Id @GeneratedValue
    private long id;
    private String name;
    private LocalDate foundedAt;
    private String description;
    private String scale;
}
