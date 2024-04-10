package com.emat.jspring_mongo.student.database;

import com.emat.jspring_mongo.student.entity.Student;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StudentRepository extends MongoRepository<Student, String> {
    List<Student> findByName(String name);
    Optional<Student> findByNameAndMail(String name, String mail);

    Optional<List<Student>> findByNameOrMail(String name, String email);
    List<Student> findByDepartmentDepartmentName(String departmentName);
}
