package cn.edu.zjut.po;

import java.io.Serializable;

public class course implements Serializable{
	private int courseID;
	private String courseName;
	private int period;//学时
	private int credit;//学分
	@Override
	public String toString() {
		return "course [courseID=" + courseID + ", courseName=" + courseName + ", period=" + period + ", credit="
				+ credit + "]";
	}
	public int getCourseID() {
		return courseID;
	}
	public void setCourseID(int courseID) {
		this.courseID = courseID;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public int getPeriod() {
		return period;
	}
	public void setPeriod(int period) {
		this.period = period;
	}
	public int getCredit() {
		return credit;
	}
	public void setCredit(int credit) {
		this.credit = credit;
	}
	
}
