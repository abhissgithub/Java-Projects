package com.SmartTrack.Student.dao;

import org.springframework.stereotype.Repository;

import com.SmartTrack.Student.dto.StudentAttendanceDTO;
import com.SmartTrack.Student.entity.Attendance;

import java.sql.*;
import java.util.*;

@Repository
public class AttendanceDAO {
    private final String url = "jdbc:mysql://localhost:3306/StuAttendance";
    private final String user = "root";
    private final String pass = "Abhishek@123";

    private Connection getCon() throws Exception {
        return DriverManager.getConnection(url, user, pass);
    }

    public int save(Attendance attendance) throws Exception {
        String sql = "INSERT INTO attendance VALUES (?, ?, ?, ?)";
        try (Connection con = getCon(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, attendance.getId());
            ps.setInt(2, attendance.getStudentId());
            ps.setDate(3, attendance.getDate());
            ps.setBoolean(4, attendance.isPresent());
            return ps.executeUpdate();
        }
    }

    public List<Attendance> findAll() throws Exception {
        List<Attendance> list = new ArrayList<>();
        String sql = "SELECT * FROM attendance";
        try (Connection con = getCon(); Statement stmt = con.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                list.add(new Attendance(
                        rs.getInt("id"),
                        rs.getInt("studentId"),
                        rs.getDate("date"),
                        rs.getBoolean("present")
                ));
            }
        }
        return list;
    }

    public List<StudentAttendanceDTO> getStudentAttendance() throws Exception {
        List<StudentAttendanceDTO> list = new ArrayList<>();
        String sql = "SELECT s.name, a.date, a.present " +
                     "FROM student s JOIN attendance a ON s.id = a.studentId";
        try (Connection con = getCon(); Statement stmt = con.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                list.add(new StudentAttendanceDTO(
                        rs.getString("name"),
                        rs.getDate("date"),
                        rs.getBoolean("present")
                ));
            }
        }
        return list;
    }
}

