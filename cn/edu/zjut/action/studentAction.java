 package cn.edu.zjut.action;

import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import cn.edu.zjut.dao.teacher_courseDao;
import cn.edu.zjut.po.student;
import cn.edu.zjut.po.student_course;
import cn.edu.zjut.po.teacher_course;
import cn.edu.zjut.service.adminService;
import cn.edu.zjut.service.studentService;

public class studentAction extends ActionSupport{
	private studentService studentService;
	private adminService adminService;
	private student student;
	private student_course student_course;
	private  teacher_course teacher_course;
	private teacher_courseDao teacher_courseDao;
	private String semester;
	
	
	public String getSemester() {
		return semester;
	}
	public void setSemester(String semester) {
		this.semester = semester;
	}
	public teacher_courseDao getTeacher_courseDao() {
		return teacher_courseDao;
	}
	public void setTeacher_courseDao(teacher_courseDao teacher_courseDao) {
		this.teacher_courseDao = teacher_courseDao;
	}
	public void setAdminService(adminService adminService) {
		this.adminService = adminService;
	}
	public student getStudent() {
		return student;
	}
	public void setStudent(student student) {
		this.student = student;
	}
	public student_course getStudent_course() {
		return student_course;
	}
	public void setStudent_course(student_course student_course) {
		this.student_course = student_course;
	}
	public teacher_course getTeacher_course() {
		return teacher_course;
	}
	public void setTeacher_course(teacher_course teacher_course) {
		this.teacher_course = teacher_course;
	}
	public void setStudentService(studentService studentService) {
		this.studentService = studentService;
	}
	
	public List getAllTeacher_courses(){
		return teacher_courseDao.findAllteacher_course();
	}
	/*
	 * 登录
	 */
	public String login(){
		ActionContext ac=ActionContext.getContext();
		Map<String,Object> session = (Map<String,Object>)ac.getSession();
		Map<String,Object> request = (Map<String,Object>)ac.get("request");
		if(studentService.login(student)){
			request.put("msg","欢迎您的到来");
			student=studentService.findByID(student);
			session.put("student", student);
			session.put("allTeacher_courses", studentService.getAllTeacher_courses());
			return "success";
		}
		return "fail";
	}
	/*
	 * 查找所有科目和成绩public List getAllScore
	 * 
	 */
	
	/*
	 * 选课
	 */
	public String chooseCourse(){
		ActionContext ac=ActionContext.getContext();
		Map<String,Object> request =  (Map<String,Object>)ac.get("request");
		Map<String,Object> session = (Map<String,Object>)ac.getSession();
		try{
			if(studentService.chooseCourse(student, teacher_course)){
				session.put("allTeacher_courses",studentService.getAllTeacher_courses());
				session.put("allStudent_courses",studentService.getAllCourses(student.getStudentID()));
				request.put("msg","选课成功");
				return "success";
			}
			return "fail";
		}catch(Exception e){
			e.printStackTrace();
			return "fail";
		}
	}
	/*
	 * 退课
	 */
	public String retired(){
		ActionContext ac=ActionContext.getContext();
		Map<String,Object> session = (Map<String,Object>)ac.getSession();
		Map<String,Object> request =  (Map<String,Object>)ac.get("request");
		try{
			if(studentService.retired(student, teacher_course)){
				session.put("allStudent_courses",studentService.getAllCourses(student.getStudentID()));
				session.put("allTeacher_courses",studentService.getAllTeacher_courses());
				request.put("msg","退课成功");
				return "success";
			}
			return "fail";
		}catch(Exception e){
			e.printStackTrace();
			return "fail";
		}
	}
	/*
	 * 查看所有的选的课程
	 */
	public String getAllStudent_course(){
		ActionContext ac=ActionContext.getContext();
		Map<String,Object> session = (Map<String,Object>)ac.getSession();
		Map<String,Object> request =  (Map<String,Object>)ac.get("request");
		try{
			List temp = studentService.getAllCourses(student.getStudentID());
			session.put("allStudent_courses",temp);
			session.put("asScore",studentService.getASScore(student.getStudentID()));
			return "success";
		}catch(Exception e){
			e.printStackTrace();
			return "fail";
		}
	}
	/*
	 * 查看gpa
	 */
	public String getGpa(){
		ActionContext ac=ActionContext.getContext();
		Map<String,Object> session = (Map<String,Object>)ac.getSession();
		try{
			System.out.println(semester);
			System.out.println(student.toString());
			session.put("gpa", studentService.getGpa(student, semester));
			return "success";
		}catch(Exception e){
			e.printStackTrace();
			return "fail";
		}
	}
	
}
