package com.emat.jspring_mongo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.config.EnableMongoAuditing;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoAuditing
@EnableMongoRepositories(value = {"com.emat.jspring_mongo.student.database"})
public class JspringMongoApplication {

    public static void main(String[] args) {
        SpringApplication.run(JspringMongoApplication.class, args);
    }

}
