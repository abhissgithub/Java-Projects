package com.SmartTrack.Student.service;

import java.util.List;


import org.springframework.stereotype.Service;

import com.SmartTrack.Student.dao.StudentDAO;
import com.SmartTrack.Student.entity.Student;

@Service
public class StudentService {
    @Override
	public String toString() {
		return "StudentService [studentDAO=" + studentDAO + "]";
	}

	private final StudentDAO studentDAO;

    public StudentService(StudentDAO studentDAO) {
        this.studentDAO = studentDAO;
    }

    public int addStudent(Student student) throws Exception {
        return studentDAO.save(student);
    }

    public List<Student> getAllStudents() throws Exception {
        return studentDAO.findAll();
    }
    
    public Student getStudentById(int id) throws Exception {
        return studentDAO.getStudentbyID(id);
    }

}

