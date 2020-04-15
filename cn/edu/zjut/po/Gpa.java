package cn.edu.zjut.po;

import java.io.Serializable;

public class Gpa implements Serializable{
	private ss ss;
	private double gpa;
	public double getGpa() {
		return gpa;
	}
	public void setGpa(double gpa) {
		this.gpa = gpa;
	}
	public student getStudent() {
		return ss.getStudent();
	}
	public void setStudent(student student) {
		this.ss.setStudent(student); 
	}
	public String getSemester() {
		return ss.getSemester();
	}
	public void setSemester(String semester) {
		this.ss.setSemester(semester);
	}
	@Override
	public String toString() {
		return "Gpa [student=" + ss.getStudent() + ", semester=" + ss.getSemester() + ", gpa=" + gpa + "]";
	}
	public ss getSs() {
		return ss;
	}
	public void setSs(ss ss) {
		this.ss = ss;
	}
	
}
