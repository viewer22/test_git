package com.devweb.test.controller;

import com.devweb.test.dto.request.studentRequest;
import com.devweb.test.dto.request.studentUpdateRequest;
import com.devweb.test.entity.Student;
import com.devweb.test.service.studentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")

public class studentController {
    @Autowired
    private studentService studentService;

    @PostMapping
    Student createStudent(@RequestBody @Valid studentRequest student) {
        return studentService.createStudent(student);
    }

    @GetMapping
    List<Student> getStudent() {
        return studentService.getStudent();
    }

    @GetMapping("/{userId}")
    Student getStudentById(@PathVariable String userId) {
        return studentService.getStudentById(userId);
    }

    @PutMapping("/{userId}")
    Student updateStudent(@PathVariable String userId, @RequestBody @Valid studentUpdateRequest student) {
        return studentService.updateStudent(userId, student);
    }

    @DeleteMapping("/{userID}")
    String deleteStudentById(@PathVariable String userID) {
        studentService.deleteStudentById(userID);
        return "success";
    }

    @PostMapping("/list")
    public List<Student> getListStudents(@RequestBody List<studentRequest> students) {
        return studentService.createList(students);
    }

}
