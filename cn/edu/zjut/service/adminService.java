package cn.edu.zjut.service;

import java.util.List;

import javax.swing.JOptionPane;

import org.springframework.transaction.annotation.Transactional;

import cn.edu.zjut.dao.JClassDao;
import cn.edu.zjut.dao.adminDao;
import cn.edu.zjut.dao.classroomDao;
import cn.edu.zjut.dao.courseDao;
import cn.edu.zjut.dao.majorDao;
import cn.edu.zjut.dao.studentDao;
import cn.edu.zjut.dao.teacherDao;
import cn.edu.zjut.dao.teacher_courseDao;
import cn.edu.zjut.po.Classroom;
import cn.edu.zjut.po.JClass;
import cn.edu.zjut.po.admin;
import cn.edu.zjut.po.course;
import cn.edu.zjut.po.major;
import cn.edu.zjut.po.student;
import cn.edu.zjut.po.teacher;
import cn.edu.zjut.po.teacher_course;

public class adminService {
	private adminDao adminDao;
	private teacherDao teacherDao;
	private studentDao studentDao;
	private courseDao courseDao;
	private teacher_courseDao teacher_courseDao;
	private classroomDao classroomDao;
	private JClassDao JClassDao;
	private majorDao majorDao;
	public void setMajorDao(majorDao majorDao) {
		this.majorDao = majorDao;
	}
	public void setJClassDao(JClassDao jClassDao) {
		JClassDao = jClassDao;
	}
	public void setClassroomDao(classroomDao classroomDao) {
		this.classroomDao = classroomDao;
	}
	public void setCourseDao(courseDao courseDao) {
		this.courseDao = courseDao;
	}
	public void setTeacher_courseDao(teacher_courseDao tcd) {
		this.teacher_courseDao = tcd;
	}
	public void setTeacherDao(teacherDao teacherDao) {
		this.teacherDao = teacherDao;
	}
	public void setAdminDao(adminDao adminDao) {
		this.adminDao = adminDao;
	}
	public void setStudentDao(studentDao studentDao) {
		this.studentDao = studentDao;
	}
	//登录
	public boolean login(admin a){
		if(adminDao.findByAccount(a.getAccount())!=null){
			if(adminDao.findByAccount(a.getAccount()).getPassword().equals(a.getPassword().trim()))
				return true;
		}
		return false;
	}
	/*
	 * 查找所有的班级
	 */
	public List getAllClass(){
		return JClassDao.findAllJClass();
	}
	/*
	 * 查找所有的专业
	 */
	public List getAllMajor(){
		return majorDao.findAllmajor();
	}
	//注册管理员
	@Transactional
	public String addAdmin(admin b,admin a){
		adminDao.save(a);
		return "success";
	}
	//修改管理员
	@Transactional
	public String changeAdmin(admin b,admin a){
		adminDao.update(a);
		return "success";
	}
	/*
	 * 根据管理员ID删除管理员
	 * 删除管理员需要权限为0
	 */
	@Transactional
	public String deleteAdmin(admin a,int id){
		adminDao.delete(id);
		return "success";
	}
	//查找所有的管理员以及他们的信息
	public List getAllAdmin(){
		return adminDao.findAlladmin();
	}
	public admin getByAccount(admin a){
		return adminDao.findByAccount(a.getAccount());
	}
	//添加学生
	@Transactional
	public String addStudent(admin a, student s,JClass jclass){
		
		if(JClassDao.findByClass(jclass.getGrade(), jclass.getClassNumber(), jclass.getMajor().getMajorName())!=null)
			s.setJClass(JClassDao.findByClass(jclass.getGrade(), jclass.getClassNumber(), jclass.getMajor().getMajorName()));
		else {
			major temp = majorDao.findByName(jclass.getMajor().getMajorName());
			if(temp!=null)
				jclass.setMajor(temp);
			s.setJClass(jclass);
		}
		try{
			studentDao.save(s);
		}catch(RuntimeException e){
			return "fail";
		}
		return "success";
	}
	//修改学生
	@Transactional
	public String changeStudent(admin a, student s,JClass jclass){
		if(JClassDao.findByClass(jclass.getGrade(), jclass.getClassNumber(), jclass.getMajor().getMajorName())!=null)
			s.setJClass(JClassDao.findByClass(jclass.getGrade(), jclass.getClassNumber(), jclass.getMajor().getMajorName()));
		else{
			major temp = majorDao.findByName(jclass.getMajor().getMajorName());
			if(temp!=null)
				jclass.setMajor(temp);
			s.setJClass(jclass);
		}
		studentDao.update(s);
		return "success";
	}
	@Transactional
	public String deleteStudent(admin a, int s){
		studentDao.delete(s);
		return "success";
	}
	//查找所有的学生以及他们的信息
	public List getAllStudents(){
		return studentDao.findAllstudent();
	}
	//通过学号查找学生
	public student getStudent(int sid){
		return studentDao.findById(sid);
	}
	//添加老师
	@Transactional
	public String addTeacher(admin a, teacher s){
		teacherDao.save(s);
		return "success";
	}
	//修改老师
	@Transactional
	public String changeTeacher(admin a, teacher s){
		teacherDao.update(s);
		return "success";
	}
	//删除老师
	@Transactional
	public String deleteTeacher(admin a, int s){
		teacherDao.delete(s);
		return "success";
	}
	//通过工号查找老师
	public teacher getTeacher(int tid){
		return teacherDao.findById(tid);
	}
	//查找所有的老师以及他们的信息
	public List getAllTeachers(){
		return teacherDao.findAllteacher();
	}
	//添加课程
	@Transactional
	public String addCourse(admin a, course s){
		courseDao.save(s);
		return "success";
	}
	//修改课程
	@Transactional
	public String changeCourse(admin a, course s){
		courseDao.update(s);
		return "success";
	}
	//删除课程
	@Transactional
	public String deleteCourse(admin a, int s){
		courseDao.delete(s);
		return "success";
	}
	//查找所有的课程以及他们的信息
	public List getAllCourses(){
		return courseDao.findAllcourse();
	}
	//给老师安排课程
	@Transactional
	public String addArrangeCourse(admin a ,int teacherID,int classroomID,int courseID,String semester){
		List temp = teacher_courseDao.findByTId(teacherID);
		
		teacher_course tc = new teacher_course();
		Classroom classroom = classroomDao.findById(classroomID);
		for(int i =0;i<temp.size();i++){
			teacher_course te = (teacher_course)temp.get(i);
			if(te.getClassroom().getTime().equals(classroom.getTime())&&te.getSemester().equals(semester)){
				JOptionPane.showMessageDialog(null, "教师安排时间冲突");
				return "fail";
			}
		}
		teacher t = teacherDao.findById(teacherID);
		course course = courseDao.findById(courseID);
		tc.setSemester(semester);
		tc.setClassroom(classroom);
		tc.setCourse(course);
		tc.setTeacher(t);
		teacher_courseDao.save(tc);
		return "success";
	}
	/*
	 * 修改安排
	 */
	@Transactional
	public String changeTeacher_course(admin a,int tcid,int tid, int cid, int coid, String semester){
		List temp = teacher_courseDao.findByTId(tid);
		
		teacher_course tc = teacher_courseDao.findById(tcid);
		Classroom classroom = classroomDao.findById(cid);
		for(int i =0;i<temp.size();i++){
			teacher_course te = (teacher_course)temp.get(i);
			if(te.getClassroom().getTime().equals(classroom.getTime())&&te.getSemester().equals(semester)){
				JOptionPane.showMessageDialog(null, "教师安排时间冲突");
				return "fail";
			}
		}
		teacher t = teacherDao.findById(tid);
		course course = courseDao.findById(coid);
		tc.setSemester(semester);
		tc.setClassroom(classroom);
		tc.setCourse(course);
		tc.setTeacher(t);
		teacher_courseDao.update(tc);
		return "success";
	}
	@Transactional
	public String deleteTeacher_course(admin a,int  ts){
		teacher_courseDao.deleteById(ts);
		return "success";
	}
	
	public List getAllTeacher_courses(){
		return teacher_courseDao.findAllteacher_course();
	}
	//添加教室
	@Transactional
	public String addClassroom(admin a, Classroom s){
		classroomDao.save(s);
		return "success";
	}
	//修改教室
	@Transactional
	public String changeClassroom(admin a, Classroom s){
		classroomDao.update(s);
		return "success";
	}
	//删除教室
	@Transactional
	public String deleteClassroom(admin a, int s){
		classroomDao.delete(s);
		return "success";
	}
	//查找所有的教室以及他们的信息
	public List getAllClassroom(){
		return classroomDao.findAllclassroom();
	}
}
