package com.SmartTrack.Student.service;

import org.springframework.stereotype.Service;

import com.SmartTrack.Student.dao.AttendanceDAO;
import com.SmartTrack.Student.dto.StudentAttendanceDTO;
import com.SmartTrack.Student.entity.Attendance;

import java.util.List;

@Service
public class AttendanceService {
    private final AttendanceDAO attendanceDAO;

    public AttendanceService(AttendanceDAO attendanceDAO) {
        this.attendanceDAO = attendanceDAO;
        
    }

    public int addAttendance(Attendance attendance) throws Exception {
        return attendanceDAO.save(attendance);
    }

    public List<Attendance> getAllAttendance() throws Exception {
        return attendanceDAO.findAll();
    }

    public List<StudentAttendanceDTO> getStudentAttendance() throws Exception {
        return attendanceDAO.getStudentAttendance();
        
    }
}
