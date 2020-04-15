package cn.edu.zjut.po;

import java.io.Serializable;

public class major implements Serializable{
	private int majorID;
	private college college;
	private String majorName;
	public int getMajorID() {
		return majorID;
	}
	public void setMajorID(int majorID) {
		this.majorID = majorID;
	}
	public college getCollege() {
		return college;
	}
	public void setCollege(college college) {
		this.college = college;
	}
	public String getMajorName() {
		return majorName;
	}
	public void setMajorName(String majorName) {
		this.majorName = majorName;
	}
	@Override
	public String toString() {
		return "major [majorID=" + majorID + ", college=" + college + ", majorName=" + majorName + "]";
	}
	
}
