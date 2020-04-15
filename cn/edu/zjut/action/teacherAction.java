package cn.edu.zjut.action;

import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import cn.edu.zjut.po.student_course;
import cn.edu.zjut.po.teacher;
import cn.edu.zjut.po.teacher_course;
import cn.edu.zjut.service.teacherService;

public class teacherAction extends ActionSupport{
	private teacherService teacherService;
	private teacher teacher;
	private teacher_course teacher_course;
	private student_course student_course;
	
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

	/*
	 * 登录
	 */
	public String login(){
		ActionContext ac = ActionContext.getContext();
		Map<String,Object> session = (Map<String,Object>)ac.getSession();
		Map<String,Object> request = (Map<String,Object>)ac.get("request");
		teacher = teacherService.login(teacher);
		if(teacher!=null){
			request.put("msg","欢迎您的到来");
			session.put("allTeacher_courses", teacherService.getAllCourses(teacher.getTeacherID()));	
			session.put("teacher", teacher);
			return "success";
		}
			
		return "fail";
	}
	
	public void setTeacherService(teacherService teacherService) {
		this.teacherService = teacherService;
	}

	public teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(teacher teacher) {
		this.teacher = teacher;
	}

	/*
	 * 查看所有学生
	 * 
	 */
	public String getAllStudents(){
		ActionContext ac = ActionContext.getContext();
		Map<String,Object> session = (Map<String,Object>)ac.getSession();
		Map<String,Object> request = (Map<String,Object>)ac.get("request");
		try{
			 session.put("allStudents", teacherService.getAllStudents(teacher_course.getTeacher_courseID()));
			 session.put("class_avgScore", teacherService.getClass_avg(teacher_course.getTeacher_courseID()));
			 return "success";
		}catch(Exception e){
			request.put("msg", "查找失败");
			e.printStackTrace();
			return "fail";
		}
	}
	/*
	 * 得到所有的课程
	 */
	public String getAllCourses(){
		ActionContext ac = ActionContext.getContext();
		Map<String,Object> session = (Map<String,Object>)ac.getSession();
		try{
			if(session.get("allTeacher_courses")==null)
			 session.put("allTeacher_courses", teacherService.getAllCourses(teacher.getTeacherID()));
			
			return "success";
		}catch(Exception e){
			e.printStackTrace();
			return "fail";
		}
	}
	/*
	 * 打分
	 */
	public String setScore(){
		ActionContext ac = ActionContext.getContext();
		Map<String,Object> request = (Map<String,Object>)ac.get("request");
		Map<String,Object> session = (Map<String,Object>)ac.getSession();
		try{
			teacherService.setScore(student_course.getStudent().getStudentID(),student_course.getTeacher_course().getTeacher_courseID(),student_course.getGrade());
			session.put("allStudents", teacherService.getAllStudents(student_course.getTeacher_course().getTeacher_courseID()));
			 session.put("class_avgScore", teacherService.getClass_avg(teacher_course.getTeacher_courseID()));
			request.put("msg", "登记成功");
			return "success";
		}catch(Exception e){
			e.printStackTrace();
			return "fail";
		}
	}
}
