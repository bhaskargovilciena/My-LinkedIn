package com.mylinkedin.first_project.models;

import lombok.Data;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;

import java.time.LocalDate;

@Node
@Data
public class Post {
    @Id @GeneratedValue
    private String id;
    private String content;
    private LocalDate createdAt;
    private int likes;
}
