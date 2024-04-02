package com.emat.jspring_mongo.student.application;

import com.emat.jspring_mongo.student.CreateStudentCommand;
import com.emat.jspring_mongo.student.StudentResponse;
import com.emat.jspring_mongo.student.UpdateStudentCommand;

import java.util.List;
import java.util.Optional;

public interface StudentService {
    StudentResponse createStudent(CreateStudentCommand command);
    Optional<StudentResponse> getStudentById(String id);
    List<StudentResponse> getAllStudents();
    Optional<StudentResponse> updateStudent(UpdateStudentCommand command);
    void deleteStudent(String id);
    List<StudentResponse> getStudentsByName(String name);
    Optional<StudentResponse> findStudentByNameAndEmail(String name, String email);
    Optional<StudentResponse> findStudentByNameOrEmail(String name, String email);
    List<StudentResponse> getAllStudentsWithPagination(int noPerPage, int page);
    List<StudentResponse> getAllStudentsWithASCSorting(String lastName);
    List<StudentResponse> getStudentsByDepartmentName(String departmentName);
    List<StudentResponse> getStudentsBySubjectName(String subName);
    List<StudentResponse> emailLike(String email);
    List<StudentResponse> nameStartWith(String name);

}