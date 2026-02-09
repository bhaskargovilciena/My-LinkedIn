package com.mylinkedin.first_project.relationships;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mylinkedin.first_project.models.User;
import lombok.Data;
import org.springframework.data.neo4j.core.schema.*;

import java.util.ArrayList;
import java.util.List;

@RelationshipProperties
@Data
public class Follow {
    @Id @GeneratedValue
    private String id;

    @JsonIgnore
    @TargetNode
    private List<User> users = new ArrayList<>();
}
