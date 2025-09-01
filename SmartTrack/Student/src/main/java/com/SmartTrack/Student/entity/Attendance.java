package com.SmartTrack.Student.entity;

import java.sql.Date;

public class Attendance {
    @Override
	public String toString() {
		return "Attendance [id=" + id + ", studentId=" + studentId + ", date=" + date + ", present=" + present + "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getStudentId() {
		return studentId;
	}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
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
	private int id;
    private int studentId;
    private Date date;
    private boolean present;

    public Attendance() {}
    public Attendance(int id, int studentId, Date date, boolean present) {
        this.id = id;
        this.studentId = studentId;
        this.date = date;
        this.present = present;
    }

    
}