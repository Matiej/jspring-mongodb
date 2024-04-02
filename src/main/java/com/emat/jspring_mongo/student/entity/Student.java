package com.emat.jspring_mongo.student.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.*;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import static java.util.UUID.randomUUID;

@Getter
@Setter
@AllArgsConstructor(onConstructor=@__({@PersistenceConstructor}))
@NoArgsConstructor
@Document(collation = "student")
public class Student {

    @Id
    private String id;
    private String UUID = randomUUID().toString();
    @Field(name = "name")
    private String name;
    @Field(name = "email")
    private String mail;
    private Department department;
    private Set<Subject> subjects = new HashSet<>();
    @CreatedDate
    private LocalDateTime createdAt;
    @LastModifiedDate
    private LocalDateTime lastUpdatedAt;
    @Version
    private long version;

    public void setSubjects(Set<Subject> subjects) {
        Set<Subject> subjectSet = new HashSet<>(subjects);
        this.subjects = subjectSet;
    }
}
