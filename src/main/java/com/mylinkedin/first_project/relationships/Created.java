package com.mylinkedin.first_project.relationships;

import com.mylinkedin.first_project.models.Post;
import lombok.Data;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.RelationshipProperties;
import org.springframework.data.neo4j.core.schema.TargetNode;

@RelationshipProperties
@Data
public class Created {
    @Id @GeneratedValue
    private String id;

    @TargetNode
    private Post post;
}
