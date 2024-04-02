package com.emat.jspring_mongo.student.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Field;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Department {
    @Field
    private String departmentName;
    @Field
    private String location;
}
