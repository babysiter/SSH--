package cn.edu.zjut.po;

import java.io.Serializable;

public class student_course implements Serializable{
	private curriculum cc;
	private double grade=0;
	public student getStudent(){
		return cc.getStudent();
	}
	public void setStudent(student s){
		cc.setStudent(s);
	}
	public void setTeacher_course(teacher_course t){
		cc.setTeacher_course(t);
	}
	public teacher_course getTeacher_course(){
		return cc.getTeacher_course();
	}
	public curriculum getCc() {
		return cc;
	}
	public void setCc(curriculum cc) {
		this.cc = cc;
	}
	public double getGrade() {
		return grade;
	}
	public void setGrade(double grade) {
		this.grade = grade;
	}
	@Override
	public String toString() {
		return "student_course [cc=" + cc + ", grade=" + grade + "]";
	}
	
}
