package cn.edu.zjut.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import cn.edu.zjut.dao.gpaDao;
import cn.edu.zjut.dao.studentDao;
import cn.edu.zjut.dao.student_courseDao;
import cn.edu.zjut.dao.teacherDao;
import cn.edu.zjut.dao.teacher_courseDao;
import cn.edu.zjut.po.Gpa;
import cn.edu.zjut.po.curriculum;
import cn.edu.zjut.po.ss;
import cn.edu.zjut.po.student;
import cn.edu.zjut.po.student_course;
import cn.edu.zjut.po.teacher;
import cn.edu.zjut.po.teacher_course;

public class teacherService {
	private teacher_courseDao teacher_courseDao;
	private student_courseDao student_courseDao;
	private teacherDao teacherDao;
	private studentDao studentDao;
	private gpaDao gpaDao;
	
	
	
	public void setGpaDao(gpaDao gpaDao) {
		this.gpaDao = gpaDao;
	}
	public studentDao getStudentDao() {
		return studentDao;
	}
	public void setStudentDao(studentDao studentDao) {
		this.studentDao = studentDao;
	}
	public void setStudent_courseDao(student_courseDao student_courseDao) {
		this.student_courseDao = student_courseDao;
	}
	public void setTeacher_courseDao(teacher_courseDao teacher_courseDao) {
		this.teacher_courseDao = teacher_courseDao;
	}
	public void setTeacherDao(teacherDao teacherDao) {
		this.teacherDao = teacherDao;
	}
	
	//登录
	public teacher login(teacher a){
		teacher temp = teacherDao.findByAccount(a.getAccount());
		if(temp!=null){
			if(temp.getPassword().equals(a.getPassword().trim())){
				return temp;
			}
				
		}
		return null;
	}
	//查看班级平均成绩
	public double getClass_avg(int tid){
		return teacher_courseDao.class_avg(tid);
	}
	//查看课程表
	public List getAllCourses(int sid){
		return teacher_courseDao.findByTId(sid);
	}
	//查询自己班级的学生信息
	public List getAllStudents(int tid){
		return student_courseDao.findByTid(tid);
	}
	@Transactional
	public void setScore(int sid,int tid,double grade){
		//得到学生信息
		student student;
		student_course sc;
		//得到课程信息
		teacher_course teacher_course=teacher_courseDao.findById(tid);
		sc = (student_course) student_courseDao.findBySTId(sid,tid);
		student = studentDao.findById(sid);
		if(sc!=null){
			//sc.setStudent(student);
			sc.setTeacher_course(teacher_course);
			sc.setGrade(grade);
			//更新学生成绩
			student_courseDao.update(sc);
			if(grade<60){
				return;
			}
		}else {
			sc=new student_course();
			curriculum cc = new curriculum();
			cc.setStudent(student);
			cc.setTeacher_course(teacher_course);
			sc.setCc(cc);
			//更新学生成绩
			student_courseDao.save(sc);
			if(grade<60){
				return;
			}
		}
		//得到总的学分
		int credit = student.getStudent_credit() + teacher_course.getCourse().getCredit();
		//更新gpa
		Gpa gpa = gpaDao.findBySTId(student.getStudentID(), teacher_course.getSemester());
		
		if(gpa!=null){
			double new_gpa =((grade-50)/10*teacher_course.getCourse().getCredit() + gpa.getGpa()*student.getStudent_credit())/(teacher_course.getCourse().getCredit()+student.getStudent_credit());
			//double new_gpa = ((grade-50)/10*teacher_course.getCourse().getCredit() + gpa.getGpa()*student.getStudent_credit() - (sc.getGrade()-50)/10*teacher_course.getCourse().getCredit() )/(teacher_course.getCourse().getCredit()+student.getStudent_credit());
			gpa.setGpa(new_gpa);
			gpaDao.update(gpa);
		}else{
			gpa = new Gpa();
			double new_gpa =(grade-50)/10;
			//现为ss申请空间，否则空指针
			ss ss =new ss();
			ss.setSemester(teacher_course.getSemester());
			ss.setStudent(student);
			gpa.setGpa(new_gpa);
			gpa.setSs(ss);
			gpaDao.save(gpa);
		}
		
		//更新学生学分
			student.setStudent_credit(credit);
			studentDao.update(student);
	}
	
}
