package cn.edu.zjut.po;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class student implements Serializable{
	private int studentID;
	private String student_name;
	private int sex;//0:男，1：女
	private String IDNumber;//身份证号
	private String address;
	private String phone;
	private int student_credit;//已修学分
	private JClass JClass;
	private String account;
	private String password;
	//private Set student_course=new HashSet();//课程表
	public int getStudentID() {
		return studentID;
	}
	public void setStudentID(int studentID) {
		this.studentID = studentID;
	}
	public String getStudent_name() {
		return student_name;
	}
//	public Set getStudent_course() {
//		return student_course;
//	}
//	public void setStudent_course(Set student_course) {
//		this.student_course = student_course;
//	}
	public void setStudent_name(String student_name) {
		this.student_name = student_name;
	}
	public int getSex() {
		return sex;
	}
	public void setSex(int sex) {
		this.sex = sex;
	}
	public String getIDNumber() {
		return IDNumber;
	}
	public void setIDNumber(String iDNumber) {
		IDNumber = iDNumber;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public int getStudent_credit() {
		return student_credit;
	}
	public void setStudent_credit(int student_credit) {
		this.student_credit = student_credit;
	}
	public JClass getJClass() {
		return JClass;
	}
	public void setJClass(JClass class1) {
		JClass = class1;
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
		return "student [studentID=" + studentID + ", student_name=" + student_name + ", sex=" + sex + ", IDNumber="
				+ IDNumber + ", address=" + address + ", phone=" + phone + ", student_credit=" + student_credit
				+ ", JClass=" + JClass + ", account=" + account + ", password=" + password + "]";
	}
	
}
