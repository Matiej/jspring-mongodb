package com.emat.jspring_mongo.student;

import com.emat.jspring_mongo.student.entity.Department;
import com.emat.jspring_mongo.student.entity.Student;
import com.emat.jspring_mongo.student.entity.Subject;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.Set;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
public class CreateStudentCommand {
    private String name;
    private String mail;
    private Department department;
    private Set<Subject> subjects;

    public  Student toStudent() {
        Student student = new Student();
        student.setName(this.name);
        student.setMail(mail);
        student.setDepartment(department);
        student.setSubjects(subjects);
        return student;
    }

}
