package cn.edu.zjut.po;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class teacher implements Serializable{
	private int teacherID;
	private String teacher_name;
	private int sex;
	private String address;
	private String IDNumber;
	private String phone;
	private String office;
	private String account;
	private String password;
//	private Set teacher_course=new HashSet();
//	public Set getTeacher_course() {
//		return teacher_course;
//	}
//	public void setTeacher_course(Set teacher_course) {
//		this.teacher_course = teacher_course;
//	}
	public int getTeacherID() {
		return teacherID;
	}
	public void setTeacherID(int teacherID) {
		this.teacherID = teacherID;
	}
	public String getTeacher_name() {
		return teacher_name;
	}
	public void setTeacher_name(String teacher_name) {
		this.teacher_name = teacher_name;
	}
	public int getSex() {
		return sex;
	}
	public void setSex(int sex) {
		this.sex = sex;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getIDNumber() {
		return IDNumber;
	}
	public void setIDNumber(String iDNumber) {
		IDNumber = iDNumber;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getOffice() {
		return office;
	}
	public void setOffice(String office) {
		this.office = office;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "teacher [teacherID=" + teacherID + ", teacher_name=" + teacher_name + ", sex=" + sex + ", address="
				+ address + ", IDNumber=" + IDNumber + ", phone=" + phone + ", office=" + office + ", account="
				+ account + ", password=" + password + "]";
	}
	
}
