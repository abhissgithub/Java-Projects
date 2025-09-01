package com.SmartTrack.Student.controller;

import org.springframework.web.bind.annotation.*;

import com.SmartTrack.Student.entity.Student;
import com.SmartTrack.Student.service.StudentService;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping
    public String addStudent(@RequestBody Student student) throws Exception {
        int rows = studentService.addStudent(student);
        return rows + " student(s) added";
    }

    @GetMapping
    public List<Student> getStudents() throws Exception {
        return studentService.getAllStudents();
    }
    
    
    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable int id) throws Exception {
        return studentService.getStudentById(id);
    }

}
