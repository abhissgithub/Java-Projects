package com.SmartTrack.Student.dao;

import org.springframework.stereotype.Repository;

import com.SmartTrack.Student.entity.Student;

import java.sql.*;
import java.util.*;

@Repository
public class StudentDAO {
    private final String url = "jdbc:mysql://localhost:3306/StuAttendance";
    private final String user = "root";
    private final String pass = "Abhishek@123";

    private Connection getCon() throws Exception {
        return DriverManager.getConnection(url, user, pass);
    }

    public int save(Student student) throws Exception {
        String sql = "INSERT INTO student VALUES (?, ?, ?, ?)";
        try (Connection con = getCon(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, student.getId());
            ps.setString(2, student.getName());
            ps.setDouble(3, student.getMarks());
            ps.setString(4, student.getHobby());
            return ps.executeUpdate();
        }
    }

    public List<Student> findAll() throws Exception {
        List<Student> students = new ArrayList<>();
        String sql = "SELECT * FROM student";
        try (Connection con = getCon(); Statement stmt = con.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                students.add(new Student(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getDouble("marks"),
                        rs.getString("hobby")
                ));
            }
        }
        return students;
    }
    
    public Student getStudentbyID(int id) throws Exception{
    	
    	String sql = "SELECT * from student where id = ?";
    	
    	
    	try (    		
    			
    		Connection con = getCon();
    		PreparedStatement ps = con.prepareStatement(sql)){
    			
    			ps.setInt(1, id);
    			
    			try(ResultSet rs = ps.executeQuery()){
    				
    				if(rs.next()) {
    					
    					return new Student(
    							
    							rs.getInt("id"),
    							rs.getString("name"),
    							rs.getDouble("marks"),
    	                        rs.getString("hobby")
    				);
    							
    				}
    			}
    		}
    		
    	return null;

    	}
    	
  
}

