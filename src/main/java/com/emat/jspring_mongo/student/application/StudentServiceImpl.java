package com.emat.jspring_mongo.student.application;

import com.emat.jspring_mongo.student.CreateStudentCommand;
import com.emat.jspring_mongo.student.StudentResponse;
import com.emat.jspring_mongo.student.UpdateStudentCommand;
import com.emat.jspring_mongo.student.database.StudentRepository;
import com.emat.jspring_mongo.student.entity.Student;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;

    @Override
    public StudentResponse createStudent(CreateStudentCommand command) {
        Student savedStudent = studentRepository.save(command.toStudent());
        return new StudentResponse().toStudentResponse(savedStudent);
    }

    @Override
    public Optional<StudentResponse> getStudentById(String id) {
        return Optional.empty();
    }

    @Override
    public List<StudentResponse> getAllStudents() {
        return null;
    }

    @Override
    public Optional<StudentResponse> updateStudent(UpdateStudentCommand command) {
        return Optional.empty();
    }

    @Override
    public void deleteStudent(String id) {

    }

    @Override
    public List<StudentResponse> getStudentsByName(String name) {
        return null;
    }

    @Override
    public Optional<StudentResponse> findStudentByNameAndEmail(String name, String email) {
        return Optional.empty();
    }

    @Override
    public Optional<StudentResponse> findStudentByNameOrEmail(String name, String email) {
        return Optional.empty();
    }

    @Override
    public List<StudentResponse> getAllStudentsWithPagination(int noPerPage, int page) {
        return null;
    }

    @Override
    public List<StudentResponse> getAllStudentsWithASCSorting(String lastName) {
        return null;
    }

    @Override
    public List<StudentResponse> getStudentsByDepartmentName(String departmentName) {
        return null;
    }

    @Override
    public List<StudentResponse> getStudentsBySubjectName(String subName) {
        return null;
    }

    @Override
    public List<StudentResponse> emailLike(String email) {
        return null;
    }

    @Override
    public List<StudentResponse> nameStartWith(String name) {
        return null;
    }
}
