package com.SmartTrack.Student.dto;

import java.sql.Date;

public class StudentAttendanceDTO {
    @Override
	public String toString() {
		return "StudentAttendanceDTO [studentName=" + studentName + ", date=" + date + ", present=" + present + "]";
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public boolean isPresent() {
		return present;
	}

	public void setPresent(boolean present) {
		this.present = present;
	}

	private String studentName;
    private Date date;
    private boolean present;

    public StudentAttendanceDTO(String studentName, Date date, boolean present) {
        this.studentName = studentName;
        this.date = date;
        this.present = present;
    }

    // getters + setters
}