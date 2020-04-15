package cn.edu.zjut.po;

public class student_score {
	private int studentID;
	private Double studentAVG;
	private Double studentSUM;
	private String studentName;
	public Double getStudentSUM() {
		return studentSUM;
	}
	public void setStudentSUM(Double studentSUM) {
		this.studentSUM = studentSUM;
	}
	
	public int getStudentID() {
		return studentID;
	}
	public void setStudentID(int studentID) {
		this.studentID = studentID;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public Double getStudentAVG() {
		return studentAVG;
	}
	public void setStudentAVG(Double studentAVG) {
		this.studentAVG = studentAVG;
	}
	@Override
	public String toString() {
		return "student_score [studentID=" + studentID + ", studentAVG=" + studentAVG + ", studentSUM=" + studentSUM
				+ ", studentName=" + studentName + "]";
	}
	
	
}
