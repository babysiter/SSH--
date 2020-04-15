package cn.edu.zjut.po;

public class Classroom {
	private int classroomID;
	private String place;//上课地点
	private String time;//上课时间
	private int maxPeople;//最大容量
	
	
	
	public int getClassroomID() {
		return classroomID;
	}
	public void setClassroomID(int classroomID) {
		this.classroomID = classroomID;
	}
	public String getPlace() {
		return place;
	}
	public void setPlace(String place) {
		this.place = place;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public int getMaxPeople() {
		return maxPeople;
	}
	public void setMaxPeople(int maxPeople) {
		this.maxPeople = maxPeople;
	}
	
	@Override
	public String toString() {
		return "Classroom [classroomID=" + classroomID + ", place=" + place + ", time=" + time + ", maxPeople="
				+ maxPeople   + "]";
	}
	
}
