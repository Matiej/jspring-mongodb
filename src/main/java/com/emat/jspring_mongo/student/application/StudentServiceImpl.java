package com.emat.jspring_mongo.student.application;

import com.emat.jspring_mongo.student.CreateStudentCommand;
import com.emat.jspring_mongo.student.StudentResponse;
import com.emat.jspring_mongo.student.UpdateStudentCommand;
import com.emat.jspring_mongo.student.database.StudentRepository;
import com.emat.jspring_mongo.student.entity.Student;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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
        return studentRepository.findById(id).map(student -> new StudentResponse().toStudentResponse(student));
    }

    @Override
    public List<StudentResponse> getAllStudents() {
        return studentRepository.findAll()
                .stream()
                .map(student -> new StudentResponse().toStudentResponse(student))
                .toList();
    }

    @Override
    public Optional<StudentResponse> updateStudent(UpdateStudentCommand command) {
        return studentRepository.findById(command.getStudentId())
                .map(studentFromDB -> new StudentResponse().toStudentResponse(studentRepository.save(command.toStudent(studentFromDB.getCreatedAt()))));
    }

    @Override
    public void deleteStudent(String id) {
        studentRepository.deleteById(id);
    }

    @Override
    public List<StudentResponse> getStudentsByName(String name) {
        return getResponseList(name);
    }

    private List<StudentResponse> getResponseList(String name) {
        return new StudentResponse().toStudentResponseList(studentRepository.findByName(name));
    }

    @Override
    public Optional<StudentResponse> findStudentByNameAndEmail(String name, String email) {
        return studentRepository.findByNameAndMail(name, email)
                .map(student -> new StudentResponse().toStudentResponse(student));
    }

    @Override
    public Optional<List<StudentResponse>> findStudentsByNameOrEmail(String name, String email) {
        return studentRepository.findByNameOrMail(name, email)
                .map(student -> new StudentResponse().toStudentResponseList(student));
    }

    @Override
    public List<StudentResponse> getAllStudentsWithPagination(int pageNumber
            , int pageSize) {
        Pageable pageable = PageRequest.of(pageNumber - 1, pageSize);
        return new StudentResponse().toStudentResponseList(studentRepository.findAll(pageable).getContent());
    }

    @Override
    public List<StudentResponse> getAllStudentsSortedByEmailAsc(String property, int sortingOrder) {
        Sort sorting;
        if (sortingOrder == 1) {
            sorting = Sort.by(property).ascending();
        } else {
            sorting = Sort.by(Sort.Direction.DESC, property);
        }
        return new StudentResponse().toStudentResponseList(studentRepository.findAll(sorting));
    }

    @Override
    public List<StudentResponse> getStudentsByDepartmentName(String departmentName) {
        return new StudentResponse().toStudentResponseList(studentRepository.findByDepartmentDepartmentName(departmentName));
    }

    @Override
    public List<StudentResponse> getStudentsBySubjectName(String subName) {
        return new StudentResponse().toStudentResponseList(studentRepository.findBySubjectsSubjectName(subName));
    }

    @Override
    public List<StudentResponse> emailLike(String mail) {
        return new StudentResponse().toStudentResponseList(studentRepository.findByMailIsLike(mail));
    }

    @Override
    public List<StudentResponse> nameStartWith(String namePrefix) {
        return new StudentResponse().toStudentResponseList(studentRepository.findByNameStartingWith(namePrefix));
    }

    @Override
    public List<StudentResponse> createStudents(List<CreateStudentCommand> command) {
        List<Student> students = studentRepository.saveAll(command.stream().map(CreateStudentCommand::toStudent).toList());
        return new StudentResponse().toStudentResponseList(students);
    }
}
