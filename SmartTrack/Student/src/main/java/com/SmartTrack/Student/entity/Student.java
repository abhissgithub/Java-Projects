package com.SmartTrack.Student.entity;

public class Student {
    @Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", marks=" + marks + ", hobby=" + hobby + "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getMarks() {
		return marks;
	}
	public void setMarks(double marks) {
		this.marks = marks;
	}
	public String getHobby() {
		return hobby;
	}
	public void setHobby(String hobby) {
		this.hobby = hobby;
	}
	private int id;
    private String name;
    private double marks;
    private String hobby;

    // constructors
    public Student() {}
    public Student(int id, String name, double marks, String hobby) {
        this.id = id;
        this.name = name;
        this.marks = marks;
        this.hobby = hobby;
    }
}
