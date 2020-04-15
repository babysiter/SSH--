package cn.edu.zjut.po;

import java.io.Serializable;

public class curriculum implements Serializable{
	private student student;
	private teacher_course teacher_course;
	public student getStudent() {
		return student;
	}
	public void setStudent(student student) {
		this.student = student;
	}
	public teacher_course getTeacher_course() {
		return teacher_course;
	}
	public void setTeacher_course(teacher_course teacher_course) {
		this.teacher_course = teacher_course;
	}
	@Override
	public String toString() {
		return "curriculum [student=" + student + ", teacher_course=" + teacher_course + "]";
	}
	
}
