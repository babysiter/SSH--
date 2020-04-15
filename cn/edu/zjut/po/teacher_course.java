package cn.edu.zjut.po;

import java.io.Serializable;

public class teacher_course implements Serializable{
	private int teacher_courseID;
	private teacher teacher;
	private course course;
	private Classroom classroom;
	private String semester;
	private int alPeople;
	
	public int getAlPeople() {
		return alPeople;
	}
	public void setAlPeople(int alPeople) {
		this.alPeople = alPeople;
	}
	public int getTeacher_courseID() {
		return teacher_courseID;
	}
	public void setTeacher_courseID(int teacher_courseID) {
		this.teacher_courseID = teacher_courseID;
	}
	public teacher getTeacher() {
		return teacher;
	}
	public void setTeacher(teacher teacher) {
		this.teacher = teacher;
	}
	public course getCourse() {
		return course;
	}
	public void setCourse(course course) {
		this.course = course;
	}
	public Classroom getClassroom() {
		return classroom;
	}
	public void setClassroom(Classroom classroom) {
		this.classroom = classroom;
	}
	public String getSemester() {
		return semester;
	}
	public void setSemester(String semester) {
		this.semester = semester;
	}
	@Override
	public String toString() {
		return "teacher_course [teacher_courseID=" + teacher_courseID + ", teacher=" + teacher + ", course=" + course
				+ ", classroom=" + classroom + ", semester=" + semester + ", alPeople=" + alPeople + "]";
	}
	
}
