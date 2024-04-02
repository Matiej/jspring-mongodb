package com.emat.jspring_mongo.student;

import com.emat.jspring_mongo.student.entity.Student;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
public class UpdateStudentCommand extends CreateStudentCommand{
    private String studentId;

    public Student toStudent(LocalDateTime createdAt) {
        Student student = super.toStudent();
        student.setId(studentId);
        student.setCreatedAt(createdAt);
        return student;
    }

}
