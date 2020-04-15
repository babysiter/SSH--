package cn.edu.zjut.action;

import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import cn.edu.zjut.po.Classroom;
import cn.edu.zjut.po.JClass;
import cn.edu.zjut.po.admin;
import cn.edu.zjut.po.course;
import cn.edu.zjut.po.student;
import cn.edu.zjut.po.teacher;
import cn.edu.zjut.po.teacher_course;
import cn.edu.zjut.service.adminService;

public class adminAction extends ActionSupport{
	private adminService adminService;
	private admin admin;
	private student student;
	private teacher teacher;
	private Classroom classroom;
	private course course;
	private JClass jclass;
	private String semester;
	private teacher_course teacher_course;
	private String adminID;
	private String studentID;
	private String teacherID;
	private String courseID;
	private String classroomID;
	private String teacher_courseID;
	
	public String getAdminID() {
		return adminID;
	}
	public void setAdminID(String adminID) {
		this.adminID = adminID;
	}
	public String getStudentID() {
		return studentID;
	}
	public void setStudentID(String studentID) {
		this.studentID = studentID;
	}
	public String getTeacherID() {
		return teacherID;
	}
	public void setTeacherID(String teacherID) {
		this.teacherID = teacherID;
	}
	public String getCourseID() {
		return courseID;
	}
	public void setCourseID(String courseID) {
		this.courseID = courseID;
	}
	public String getClassroomID() {
		return classroomID;
	}
	public void setClassroomID(String classroomID) {
		this.classroomID = classroomID;
	}
	public String getTeacher_courseID() {
		return teacher_courseID;
	}
	public void setTeacher_courseID(String teacher_courseID) {
		this.teacher_courseID = teacher_courseID;
	}
	public String getSemester() {
		return semester;
	}
	public void setSemester(String semester) {
		this.semester = semester;
	}
	public JClass getJclass() {
		return jclass;
	}
	public void setJclass(JClass jclass) {
		this.jclass = jclass;
	}
	public admin getAdmin() {
		return admin;
	}
	public void setAdmin(admin admin) {
		this.admin = admin;
	}
	public student getStudent() {
		return student;
	}
	public void setStudent(student student) {
		this.student = student;
	}
	public teacher getTeacher() {
		return teacher;
	}
	public void setTeacher(teacher teacher) {
		this.teacher = teacher;
	}
	public Classroom getClassroom() {
		return classroom;
	}
	public void setClassroom(Classroom classroom) {
		this.classroom = classroom;
	}
	public course getCourse() {
		return course;
	}
	public void setAdminService(adminService adminService) {
		this.adminService = adminService;
	}
	public void setCourse(course course) {
		this.course = course;
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
		if(adminService.login(admin)){
			List major = adminService.getAllMajor();
			request.put("msg","欢迎您的到来");
			session.put("allMajors", major);
			session.put("allCourses",adminService.getAllCourses());
			session.put("allClassrooms",adminService.getAllClassroom());
			session.put("allTeachers",adminService.getAllTeachers());
			session.put("admin", adminService.getByAccount(admin));
			System.out.println("login"+((admin)session.get("admin")).toString());
			return "success";
		}
		return "fail";
	}
	/*
	 * 注册学生
	 */
	public String addStudent(){
		ActionContext ac = ActionContext.getContext();
		Map<String,Object> session = ac.getSession();	
		Map<String,Object> request = (Map<String,Object>)ac.get("request");
		try{
			String msg = adminService.addStudent((admin)session.get("admin"),student,jclass);
			if(msg.equals("fail")){
				request.put("msg", "身份证信息重复");
				return msg;
			}
			session.put("allStudents", adminService.getAllStudents());
			request.put("msg", "添加成功");
			return msg;
		}catch(Exception e){
			e.printStackTrace();
			request.put("msg", "操作失败");
			return "fail";
		}
	}
	/*
	 * 修改学生
	 */
	public String changeStudent(){
		ActionContext ac = ActionContext.getContext();
		Map<String,Object> session = ac.getSession();	
		Map<String,Object> request = (Map<String,Object>)ac.get("request");
			try{
				String msg =adminService.changeStudent((admin)session.get("admin"),student,jclass);
				session.put("allStudents", adminService.getAllStudents());
				return msg;
			}catch(Exception e){
				e.printStackTrace();
				request.put("msg", "操作失败");
				return "fail";
			}
		}
	/*
	 * 删除学生
	 */
	public String deleteStudent(){
		ActionContext ac = ActionContext.getContext();
		Map<String,Object> session = ac.getSession();	
		Map<String,Object> request = (Map<String,Object>)ac.get("request");
		try{
			String msg =adminService.deleteStudent((admin)session.get("admin"),student.getStudentID());
				session.put("allStudents", adminService.getAllStudents());
				request.put("msg", "删除成功");
				return msg;
			}catch(Exception e){
				e.printStackTrace();
				request.put("msg", "操作失败");
				return "fail";
			}
		}
	/*
	 * 查看所有学生
	 * 
	 */
	public String getAllStudents(){
		ActionContext ac = ActionContext.getContext();
		Map<String,Object> request = (Map<String,Object>)ac.get("request");
		Map<String,Object> session = ac.getSession();
		try{
			if(session.get("allStudents")==null)
				session.put("allStudents", adminService.getAllStudents());
			 return "success";
		}catch(Exception e){
			e.printStackTrace();
			request.put("msg", "操作失败");
			return "fail";
		}
	}
	/*
	 * 注册管理员
	 */
	public String addAdmin(){
		ActionContext ac = ActionContext.getContext();
		Map<String,Object> session = ac.getSession();	
		Map<String,Object> request = (Map<String,Object>)ac.get("request");
		try{
			String msg =adminService.addAdmin((admin)session.get("admin"),admin);
			session.put("allAdmins", adminService.getAllAdmin());
			request.put("msg", "添加成功");
			return msg;
		}catch(Exception e){
			e.printStackTrace();
			return "fail";
		}
	}
	/*
	 * 修改管理员
	 */
	public String changeAdmin(){
		ActionContext ac = ActionContext.getContext();
		Map<String,Object> session = ac.getSession();	
		Map<String,Object> request = (Map<String,Object>)ac.get("request");
		try{
				admin temp = (admin)session.get("admin");
				String msg =adminService.changeAdmin(temp,admin);
					if(admin.getAccount()==temp.getAccount())
						session.put("admin",admin);
					session.put("allAdmins", adminService.getAllAdmin());
					request.put("msg", "修改成功");
					return msg;
			}catch(Exception e){
				e.printStackTrace();
				return "fail";
			}
		}
	/*
	 * 删除管理员
	 */
	public String deleteAdmin(){
		ActionContext ac = ActionContext.getContext();
		Map<String,Object> session = ac.getSession();
		Map<String,Object> request = (Map<String,Object>)ac.get("request");
		admin temp =(admin) session.get("admin");
		try{
			if(temp.getAdminID()==admin.getAdminID()){
				request.put("msg", "你不能删除你自己");
				return "fail";
			}
			String msg =adminService.deleteAdmin(temp,admin.getAdminID());
			session.put("allAdmins", adminService.getAllAdmin());
			request.put("msg", "删除成功");
			return msg;
		}catch(Exception e){
			e.printStackTrace();
			return "fail";
		}
	}
	/*
	 * 查看所有管理员
	 * 
	 */
	public String getAllAdmins(){
		ActionContext ac = ActionContext.getContext();
		Map<String,Object> session = (Map<String,Object>)ac.getSession();
		try{
			if(session.get("allAdmins")==null)
				session.put("allAdmins", adminService.getAllAdmin());
			 return "success";
		}catch(Exception e){
			e.printStackTrace();
			return "fail";
		}
	}
	/*
	 * 注册老师
	 */
	public String addTeacher(){
		ActionContext ac = ActionContext.getContext();
		Map<String,Object> request = (Map<String,Object>)ac.get("request");
		Map<String,Object> session = (Map<String,Object>)ac.getSession();
		try{
			String msg =adminService.addTeacher((admin)session.get("admin"),teacher);
			session.put("allTeachers", adminService.getAllTeachers());
			request.put("msg", "添加成功");
			return msg;
		}catch(Exception e){
			e.printStackTrace();
			return "fail";
		}
	}
	/*
	 * 修改教师
	 */
	public String changeTeacher(){
		ActionContext ac = ActionContext.getContext();
		Map<String,Object> request = (Map<String,Object>)ac.get("request");
		Map<String,Object> session = (Map<String,Object>)ac.getSession();
			try{
				String msg =adminService.changeTeacher((admin)session.get("admin"),teacher);
				session.put("allTeachers", adminService.getAllTeachers());
				request.put("msg", "修改成功");
				return msg;
			}catch(Exception e){
				e.printStackTrace();
				return "fail";
			}
		}
	/*
	 * 删除教师
	 */
	public String deleteTeacher(){
		ActionContext ac = ActionContext.getContext();
		Map<String,Object> request = (Map<String,Object>)ac.get("request");
		Map<String,Object> session = (Map<String,Object>)ac.getSession();
		try{
			String msg =adminService.deleteTeacher((admin)session.get("admin"),teacher.getTeacherID());
			session.put("allTeachers", adminService.getAllTeachers());
			request.put("msg", "删除成功");
			return msg;
		}catch(Exception e){
			e.printStackTrace();
			return "fail";
		}
	}
	/*
	 * 查看所有老师
	 * 
	 */
	public String getAllTeachers(){
		ActionContext ac = ActionContext.getContext();
		Map<String,Object> request = (Map<String,Object>)ac.get("request");
		Map<String,Object> session = (Map<String,Object>)ac.getSession();
		try{
			if(session.get("allTeachers")!=null)
				return "success";
			 session.put("allTeachers", adminService.getAllTeachers());
			 return "success";
		}catch(Exception e){
			e.printStackTrace();
			request.put("msg", "操作失败");
			return "fail";
		}
	}
	/*
	 * 添加教室
	 */
	public String addClassroom(){
		ActionContext ac = ActionContext.getContext();
		Map<String,Object> request = (Map<String,Object>)ac.get("request");
		Map<String,Object> session = (Map<String,Object>)ac.getSession();
		try{
			String msg;
			msg = adminService.addClassroom((admin)session.get("admin"),classroom);
			session.put("allClassrooms", adminService.getAllClassroom());
			request.put("msg", "添加成功");
			return msg;
		}catch(Exception e){
			e.printStackTrace();
			request.put("msg","操作失败");
			return "fail";
		}
	}
	/*
	 * 修改教室
	 */
	public String changeClassroom(){
		ActionContext ac = ActionContext.getContext();
		Map<String,Object> request = (Map<String,Object>)ac.get("request");
		Map<String,Object> session = (Map<String,Object>)ac.getSession();
		try{
			String msg =adminService.changeClassroom((admin)session.get("admin"),classroom);
				session.put("allClassrooms", adminService.getAllClassroom());
				request.put("msg", "修改成功");
				return msg;
			}catch(Exception e){
				e.printStackTrace();
				request.put("msg","操作失败");
				return "fail";
			}
		}
	/*
	 * 删除教室
	 */
	public String deleteClassroom(){
		ActionContext ac = ActionContext.getContext();
		Map<String,Object> request = (Map<String,Object>)ac.get("request");
		Map<String,Object> session = (Map<String,Object>)ac.getSession();
		try{
			String msg =adminService.deleteClassroom((admin)session.get("admin"),classroom.getClassroomID());
			session.put("allClassrooms", adminService.getAllClassroom());
			request.put("msg", "删除成功");
			return msg;
		}catch(Exception e){
			e.printStackTrace();
			request.put("msg","操作失败");
			return "fail";
		}
	}
	/*
	 * 展示所有的教室
	 */
	public String getAllClassrooms(){
		ActionContext ac = ActionContext.getContext();
		Map<String,Object> request = (Map<String,Object>)ac.get("request");
		Map<String,Object> session = (Map<String,Object>)ac.getSession();
		try{
			if(session.get("allCassrooms")==null)
				session.put("allClassrooms", adminService.getAllClassroom());
			 return "success";
		}catch(Exception e){
			e.printStackTrace();
			request.put("msg", "操作失败");
			return "fail";
		}
	}
	/*
	 * 添加课程
	 */
	public String addCourse(){
		ActionContext ac = ActionContext.getContext();
		Map<String,Object> request = (Map<String,Object>)ac.get("request");
		Map<String,Object> session = (Map<String,Object>)ac.getSession();
		try{
			String msg =adminService.addCourse((admin)session.get("admin"),course);
			session.put("allCourses", adminService.getAllCourses());
			request.put("msg", "添加成功");
			return msg;
		}catch(Exception e){
			e.printStackTrace();
			request.put("msg","操作失败");
			return "fail";
		}
	}
	/*
	 * 修改课程
	 */
	public String changeCourse(){
		ActionContext ac = ActionContext.getContext();
		Map<String,Object> request = (Map<String,Object>)ac.get("request");	
		Map<String,Object> session = (Map<String,Object>)ac.getSession();
		try{
			String msg =adminService.changeCourse((admin)session.get("admin"),course);
				session.put("allCourses", adminService.getAllCourses());
				request.put("msg", "修改成功");
				return msg;
			}catch(Exception e){
				e.printStackTrace();
				request.put("msg","操作失败");
				return "fail";
			}
		}
	/*
	 * 删除课程
	 */
	public String deleteCourse(){
		ActionContext ac = ActionContext.getContext();
		Map<String,Object> request = (Map<String,Object>)ac.get("request");
		Map<String,Object> session = (Map<String,Object>)ac.getSession();
		try{
			String msg =adminService.deleteCourse((admin)session.get("admin"),course.getCourseID());
			session.put("allCourses", adminService.getAllCourses());
			request.put("msg", "删除成功");
			return msg;
		}catch(Exception e){
			e.printStackTrace();
			request.put("msg","操作失败");
			return "fail";
		}
	}
	/*
	 * 展示所有的课程
	 */
	public String getAllCourses(){
		ActionContext ac = ActionContext.getContext();
		Map<String,Object> request = (Map<String,Object>)ac.get("request");
		Map<String,Object> session = (Map<String,Object>)ac.getSession();
		try{
			if(session.get("allTeachers")!=null)
				return "success";
			 session.put("allCourses", adminService.getAllCourses());
			 return "success";
		}catch(Exception e){
			e.printStackTrace();
			request.put("msg","操作失败");
			return "fail";
		}
	}
	/*
	 * 给老师安排课程
	 */
	public String arrangeCourse(){
		ActionContext ac = ActionContext.getContext();
		Map<String,Object> session = (Map<String,Object>)ac.getSession();
		Map<String,Object> request = (Map<String,Object>)ac.get("request");
		try{
			String msg =adminService.addArrangeCourse((admin)session.get("admin"), teacher.getTeacherID(), classroom.getClassroomID(), course.getCourseID(), semester);
			session.put("allTeacher_courses", adminService.getAllTeacher_courses());
			request.put("msg", "安排成功");
			return msg;	
		}catch(Exception e){
			e.printStackTrace();
			request.put("msg","操作失败");
			return "fail";
		}
	} 
	/*
	 * 修改课程安排
	 */
	public String changeTeacher_course(){
		ActionContext ac = ActionContext.getContext();
		Map<String,Object> request = (Map<String,Object>)ac.get("request");	
		Map<String,Object> session = (Map<String,Object>)ac.getSession();
		try{
				String msg =adminService.changeTeacher_course((admin)session.get("admin"),teacher_course.getTeacher_courseID(),teacher.getTeacherID(), classroom.getClassroomID(), course.getCourseID(), semester);
				session.put("allTeacher_courses", adminService.getAllTeacher_courses());
				request.put("msg", "修改成功");
				return msg;
			}catch(Exception e){
				e.printStackTrace();
				request.put("msg","操作失败");
				return "fail";
			}
		}
	/*
	 * 删除课程
	 */
	public String deleteTeacher_course(){
		ActionContext ac = ActionContext.getContext();
		Map<String,Object> request = (Map<String,Object>)ac.get("request");
		Map<String,Object> session = (Map<String,Object>)ac.getSession();
		try{
			String msg =adminService.deleteTeacher_course((admin)session.get("admin"),teacher_course.getTeacher_courseID());
			session.put("allTeacher_courses", adminService.getAllTeacher_courses());
			return msg;
		}catch(Exception e){
			e.printStackTrace();
			request.put("msg","操作失败");
			return "fail";
		}
	}
	/*
	 * 查询所有课程安排
	 */
	public String getAllTeacher_courses(){
		ActionContext ac = ActionContext.getContext();
		Map<String,Object> session = (Map<String,Object>)ac.getSession();
		Map<String,Object> request = (Map<String,Object>)ac.get("request");
		try{
			if(session.get("allTeacher_courses")==null){
				session.put("allTeacher_courses", adminService.getAllTeacher_courses())	;			}
			return "success";
		}catch(Exception e){
			e.printStackTrace();
			request.put("msg","操作失败");
			return "fail";
		}
	}
}
