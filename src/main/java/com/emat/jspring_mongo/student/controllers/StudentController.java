package com.emat.jspring_mongo.student.controllers;

import com.emat.jspring_mongo.student.CreateStudentCommand;
import com.emat.jspring_mongo.student.StudentResponse;
import com.emat.jspring_mongo.student.UpdateStudentCommand;
import com.emat.jspring_mongo.student.application.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/students")
public class StudentController {
    private final StudentService studentService;

    @PostMapping
    public ResponseEntity<StudentResponse> createStudent(@RequestBody CreateStudentCommand command) {
        StudentResponse student = studentService.createStudent(command);
        return ResponseEntity.created(getUri(student.getId())).body(student);
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentResponse> getStudentById(@PathVariable String id) {
        return studentService.getStudentById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<StudentResponse>> getAllStudents() {
        return ResponseEntity.ok(studentService.getAllStudents());
    }

    @PutMapping
    public ResponseEntity<StudentResponse> updateStudent(@RequestBody UpdateStudentCommand command) {
        return studentService.updateStudent(command)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable String id) {
        studentService.deleteStudent(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<List<StudentResponse>> getStudentsByName(@PathVariable String name) {
        return ResponseEntity.ok(studentService.getStudentsByName(name));
    }

    @GetMapping("/search")
    public ResponseEntity<StudentResponse> findStudentByNameAndEmail(@RequestParam String name, @RequestParam String email) {
        return studentService.findStudentByNameAndEmail(name, email)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/searchOr")
    public ResponseEntity<StudentResponse> findStudentByNameOrEmail(@RequestParam String name, @RequestParam String email) {
        return studentService.findStudentByNameOrEmail(name, email)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/sort")
    public ResponseEntity<List<StudentResponse>> getAllStudentsWithASCSorting(@RequestParam String lastName) {
        return ResponseEntity.ok(studentService.getAllStudentsWithASCSorting(lastName));
    }


    @GetMapping("/pagination")
    public ResponseEntity<List<StudentResponse>> getAllStudentsWithPagination(
            @RequestParam int page,
            @RequestParam int perPage) {
        return ResponseEntity.ok(studentService.getAllStudentsWithPagination(page, perPage));
    }

    @GetMapping("/byDepartment")
    public ResponseEntity<List<StudentResponse>> getStudentsByDepartmentName(@RequestParam String departmentName) {
        return ResponseEntity.ok(studentService.getStudentsByDepartmentName(departmentName));
    }

    @GetMapping("/bySubject")
    public ResponseEntity<List<StudentResponse>> getStudentsBySubjectName(@RequestParam String subjectName) {
        return ResponseEntity.ok(studentService.getStudentsBySubjectName(subjectName));
    }

    @GetMapping("/emailLike")
    public ResponseEntity<List<StudentResponse>> emailLike(@RequestParam String emailPattern) {
        return ResponseEntity.ok(studentService.emailLike(emailPattern));
    }

    @GetMapping("/nameStartWith")
    public ResponseEntity<List<StudentResponse>> nameStartWith(@RequestParam String namePrefix) {
        return ResponseEntity.ok(studentService.nameStartWith(namePrefix));
    }

    private static URI getUri(String id) {
        return ServletUriComponentsBuilder
                .fromCurrentServletMapping()
                .path("/api")
                .path("/students")
                .path("/{id}")
                .buildAndExpand(id)
                .toUri();
    }
}
