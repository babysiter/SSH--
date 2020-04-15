package cn.edu.zjut.dao;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import cn.edu.zjut.po.student_course;
import cn.edu.zjut.po.student_score;
@Repository
public class student_courseDao extends BaseHibernateDAO{
	private Log log = LogFactory.getLog(student_course.class);
	public List findBySId(int id){
		log.debug("finding student_course instance by id");
		try{
			String hql = "from student_course c where c.cc.student.studentID=:studentID";
			Query queryObject = getSession().createQuery(hql).setInteger("studentID", id); 
			return  queryObject.list();
		}catch(RuntimeException re){
			log.error("find by id failed", re); 
			throw re;
		}
	}
	//根据学号和教室授课号查找某成绩
	public student_course findBySTId(int id,int tid){
		log.debug("finding student_course instance by id");
		try{
			String hql = "from student_course c where c.cc.student.studentID=:studentID and c.cc.teacher_course.teacher_courseID=:teacher_courseID";
			Query queryObject = getSession().createQuery(hql).setInteger("studentID", id).setInteger("teacher_courseID", tid); 
			return  (student_course)queryObject.uniqueResult();
		}catch(RuntimeException re){
			log.error("find by id failed", re); 
			throw re;
		}
	}
	//调用存储过程得到平均成绩
	public student_score asScore(int id){
		try{
			String sql = "call avgScore(:studentID)";
			Query queryObject = getSession().createSQLQuery(sql).addEntity(student_score.class).setInteger("studentID", id); 
			return  (student_score)queryObject.uniqueResult();
		}catch(RuntimeException re){
			throw re;
		}
	}
	//通过教室查询学生
	public List findByTid(int tid){
		log.debug("finding student instance by teacher_courseID");
		try{
			String hql = "from student_course c where c.cc.teacher_course.teacher_courseID=:teacher_courseID ";
			Query queryObject = getSession().createQuery(hql).setInteger("teacher_courseID", tid); 
			return  queryObject.list();
		}catch(RuntimeException re){
			log.error("find by teacher_courseID failed", re); 
			throw re;
		}
	}
	public void save(student_course instance) { 
		log.debug("saving student_course instance");
		try {
			System.out.println(instance.toString());
			getSession().persist(instance); 
			getSession().flush();
			log.debug("save successful"); 
		} catch (RuntimeException re) { 
			log.error("save failed", re); 
			throw re; 
		} 
		}
	//update by name
	public void update(student_course sc) {
		log.debug("updating student_course instance");
		try{
			getSession().update(sc);
			getSession().flush();
		}catch(RuntimeException re){
			log.error("update  failed", re); 
			throw re; 
		}
	} 
	//delete by acccount
	public void delete(int sid,int tid) {
		log.debug("deleting student_course instance");
		try{
			String hql = "delete student_course c where c.cc.student.studentID=:studentID and c.cc.teacher_course.teacher_courseID=:teacher_courseID";
			Query queryObject = getSession().createQuery(hql).setInteger("studentID", sid).setInteger("teacher_courseID", tid); 
			queryObject.executeUpdate();
			getSession().flush();
		}catch(RuntimeException re){
			log.error("delete  failed", re); 
			throw re; 
		}
	}
}
