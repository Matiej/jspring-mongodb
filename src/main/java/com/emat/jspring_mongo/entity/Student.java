package com.emat.jspring_mongo.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Set;

@Getter
@Setter
@AllArgsConstructor(onConstructor=@__({@PersistenceConstructor}))
@NoArgsConstructor
@Document(collation = "student")
public class Student {

    @Id
    private String id;
    @Field(name = "name")
    private String name;
    @Field(name = "email")
    private String mail;
    private Department department;
    private Set<Subject> subjects;

}
