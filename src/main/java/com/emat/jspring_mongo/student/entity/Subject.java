package com.emat.jspring_mongo.student.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Field;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Subject {

    @Field(name = "subject_name")
    private String subjectName;
    @Field(name = "marks_obtained")
    private int marksObtained;
}
