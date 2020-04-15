package cn.edu.zjut.po;

import java.io.Serializable;

public class ss implements Serializable{
	private student student;
	private String semester;
	public student getStudent() {
		return student;
	}
	public void setStudent(student student) {
		this.student = student;
	}
	public String getSemester() {
		return semester;
	}
	public void setSemester(String semester) {
		this.semester = semester;
	}
	@Override
	public String toString() {
		return "ss [student=" + student + ", semester=" + semester + "]";
	}
	
}
