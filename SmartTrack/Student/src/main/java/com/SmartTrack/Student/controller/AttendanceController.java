package com.SmartTrack.Student.controller;

import org.springframework.web.bind.annotation.*;

import com.SmartTrack.Student.dto.StudentAttendanceDTO;
import com.SmartTrack.Student.entity.Attendance;
import com.SmartTrack.Student.service.AttendanceService;

import java.util.List;

@RestController
@RequestMapping("/attendance")
public class AttendanceController {
    private final AttendanceService attendanceService;

    public AttendanceController(AttendanceService attendanceService) {
        this.attendanceService = attendanceService;
    }

    @PostMapping
    public String addAttendance(@RequestBody Attendance attendance) throws Exception {
        int rows = attendanceService.addAttendance(attendance);
        return rows + " attendance record(s) added";
    }

    @GetMapping
    public List<Attendance> getAttendance() throws Exception {
        return attendanceService.getAllAttendance();
    }

    @GetMapping("/student")
    public List<StudentAttendanceDTO> getStudentAttendance() throws Exception {
        return attendanceService.getStudentAttendance();
    }
}
