package cn.edu.zjut.service;

import java.util.List;

import javax.swing.JOptionPane;

import org.springframework.transaction.annotation.Transactional;

import cn.edu.zjut.dao.classroomDao;
import cn.edu.zjut.dao.gpaDao;
import cn.edu.zjut.dao.studentDao;
import cn.edu.zjut.dao.student_courseDao;
import cn.edu.zjut.dao.teacher_courseDao;
import cn.edu.zjut.po.Gpa;
import cn.edu.zjut.po.curriculum;
import cn.edu.zjut.po.ss;
import cn.edu.zjut.po.student;
import cn.edu.zjut.po.student_course;
import cn.edu.zjut.po.student_score;
import cn.edu.zjut.po.teacher_course;

public class studentService {
	private teacher_courseDao teacher_courseDao;
	private studentDao studentDao;
	private student_courseDao student_courseDao;
	private classroomDao classroomDao;
	private gpaDao gpaDao;
	
	public void setClassroomDao(classroomDao classroomDao) {
		this.classroomDao = classroomDao;
	}
	public void setGpaDao(gpaDao gpaDao) {
		this.gpaDao = gpaDao;
	}
	//登录验证
	public boolean login(student a){
		if(studentDao.findByAccount(a.getAccount())!=null){
			if(studentDao.findByAccount(a.getAccount()).getPassword().equals(a.getPassword().trim()))
				return true;
		}
		return false;
	}
	public void setTeacher_courseDao(teacher_courseDao teacher_courseDao) {
		this.teacher_courseDao = teacher_courseDao;
	}
	public void setStudentDao(studentDao studentDao) {
		this.studentDao = studentDao;
	}
	public void setStudent_courseDao(student_courseDao student_courseDao) {
		this.student_courseDao = student_courseDao;
	}
	//得到所以课程安排
	public List getAllTeacher_courses(){
		return teacher_courseDao.findAllteacher_course();
	}
	public student findByID(student s){
		return studentDao.findByAccount(s.getAccount());
	}
	//选课
	@Transactional
	public boolean chooseCourse(student s , teacher_course t){
		//从数据库找到完整的学生和课程信息
		s=studentDao.findById(s.getStudentID());
		t=teacher_courseDao.findById(t.getTeacher_courseID());
		//验证是否重复选课或者选课时间冲突
		List l= this.getAllCourses(s.getStudentID());
		student_course temp=null;
		for(int i =0;i<l.size();i++){
			temp=(student_course)l.get(i);
			if(temp.getTeacher_course().getTeacher_courseID()==t.getTeacher_courseID()){
				JOptionPane.showMessageDialog(null, "您不能重复选课");
				return false;
			}else if(temp.getTeacher_course().getClassroom().getTime().equals(t.getClassroom().getTime())){
				JOptionPane.showMessageDialog(null, "您的选课时间冲突了");
				return false;
			}
				
		}
		
		student_course sc = new student_course();
		t.setAlPeople(t.getAlPeople()+1);
		curriculum cc = new curriculum();
		sc.setCc(cc);
		sc.getCc().setStudent(s);
		sc.getCc().setTeacher_course(t);
		student_courseDao.save(sc);
		return true;
	}
	//退课
	@Transactional
	public boolean retired(student s , teacher_course t){
		//验证是否有成绩了，如果有则无法退课
		student_course sc = student_courseDao.findBySTId(s.getStudentID(),t.getTeacher_courseID());
		if(sc.getGrade()!=0){
			JOptionPane.showMessageDialog(null, "您已经有完成课程了了，无法退课");
			return false;
		}else{
			t=teacher_courseDao.findById(t.getTeacher_courseID());
			t.setAlPeople(t.getAlPeople()-1);
			teacher_courseDao.update(t);
			student_courseDao.delete(s.getStudentID(),t.getTeacher_courseID());
			return true;
		}
	}
	//查看自己的课程表
	public List getAllCourses(int sid){
		return student_courseDao.findBySId(sid);
	}
	public student_score getASScore(int sid){
		return student_courseDao.asScore(sid);
	}
	public Gpa getGpa(student s,String semester){
		Gpa temp = null;
		temp=gpaDao.findBySTId(s.getStudentID(), semester);
		if(temp==null){
			temp=new Gpa();
			ss ss= new ss();
			ss.setSemester(semester);
			ss.setStudent(studentDao.findById(s.getStudentID()));
			temp.setSs(ss);
			temp.setGpa(0);
			gpaDao.save(temp);
		}
		return temp;
	}
}
