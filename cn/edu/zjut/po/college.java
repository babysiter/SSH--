package cn.edu.zjut.po;

import java.io.Serializable;

public class college implements Serializable{
	private int collegeID;
	private String college_name;
	public int getCollegeID() {
		return collegeID;
	}
	public void setCollegeID(int collegeID) {
		this.collegeID = collegeID;
	}
	public String getCollege_name() {
		return college_name;
	}
	public void setCollege_name(String college_name) {
		this.college_name = college_name;
	}
	@Override
	public String toString() {
		return "college [collegeID=" + collegeID + ", college_name=" + college_name + "]";
	}
	
}
