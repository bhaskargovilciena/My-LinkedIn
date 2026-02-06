package com.mylinkedin.first_project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.jdbc.autoconfigure.DataSourceAutoConfiguration;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;

@EnableNeo4jRepositories(basePackages = "com.mylinkedin.first_project")
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class FirstProjectApplication {

	public static void main(String[] args) {
		System.out.println("AURADB_URI: " + System.getenv("AURADB_URI"));
		SpringApplication.run(FirstProjectApplication.class, args);
	}

}
