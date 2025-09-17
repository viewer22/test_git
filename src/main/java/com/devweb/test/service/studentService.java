package com.devweb.test.service;

import com.devweb.test.dto.request.studentRequest;
import com.devweb.test.dto.request.studentUpdateRequest;
import com.devweb.test.entity.Student;
import com.devweb.test.repository.studentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class studentService {
    @Autowired
    private studentRepository studentRepository;

    public Student createStudent(studentRequest student) {
        Student st = new Student();
        st.setId(student.getId());
        st.setName(student.getName());
        return studentRepository.save(st);
    }

    public List<Student> getStudent() {
        return studentRepository.findAll();
    }

    public List<Student> createList(List<studentRequest> students) {
        List<Student> List = new ArrayList<>();
        for (studentRequest student : students) {
            Student st = new Student();
            st.setId(student.getId());
            st.setName(student.getName());
            List.add(st);
        }
        return studentRepository.saveAll(List);
    }

    public Student getStudentById(String id) {
        return studentRepository.findById(id).orElseThrow(() -> new RuntimeException("student not found"));
    }

    public Student updateStudent(String userID, studentUpdateRequest student) {
        Student user = getStudentById(userID);
        user.setName(student.getName());
        return studentRepository.save(user);
    }

    public void deleteStudentById(String userID) {
        Student user = getStudentById(userID);
        studentRepository.delete(user);
    }
}
