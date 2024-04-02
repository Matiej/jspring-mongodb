package com.emat.jspring_mongo.student;

import com.emat.jspring_mongo.student.entity.Department;
import com.emat.jspring_mongo.student.entity.Student;
import com.emat.jspring_mongo.student.entity.Subject;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class StudentResponse {
    private String id;
    private String name;
    private String mail;
    private Department department;
    private Set<Subject> subjects;

    public StudentResponse toStudentResponse(Student student) {
        return new StudentResponse(student.getId(), student.getName(), student.getMail(), student.getDepartment(), student.getSubjects());
    }
}
