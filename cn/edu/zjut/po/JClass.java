package cn.edu.zjut.po;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class JClass implements Serializable{
	private int classID;
	private int ClassNumber;//不兼容，数据库中column为class！！！
	private int grade;
	private major major;
//	private Set students = new HashSet();
	
//	public Set getStudents() {
//		return students;
//	}
//	public void setStudents(Set student) {
//		this.students = student;
//	}
	public major getMajor() {
		return major;
	}
	public void setMajor(major major) {
		this.major = major;
	}
	public int getClassID() {
		return classID;
	}
	public void setClassID(int classID) {
		this.classID = classID;
	}
	public int getClassNumber() {
		return ClassNumber;
	}
	public void setClassNumber(int class1) {
		ClassNumber = class1;
	}
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	@Override
	public String toString() {
		return "JClass [classID=" + classID + ", ClassNumber=" + ClassNumber + ", grade=" + grade + ", major=" + major
				 + "]";
	}
	
}
