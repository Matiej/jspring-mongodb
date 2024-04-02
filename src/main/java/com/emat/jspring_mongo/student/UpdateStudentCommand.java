package com.emat.jspring_mongo.student;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
public class UpdateStudentCommand extends CreateStudentCommand{
    private String studentId;

}
