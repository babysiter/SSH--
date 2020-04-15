package cn.edu.zjut.dao;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import cn.edu.zjut.po.student_score;
import cn.edu.zjut.po.teacher_course;
@Repository
public class teacher_courseDao extends BaseHibernateDAO{
	private Log log = LogFactory.getLog(teacher_courseDao.class);
	public List findAllteacher_course() {
		log.debug("finding teacher_course"); 
		try {
			String queryString = "from teacher_course";
			Query queryObject = getSession().createQuery(queryString); 
			return queryObject.list(); 
			} catch (RuntimeException re) { 
				log.error("find by hql failed", re); 
				throw re; 
				} 
		}
	public teacher_course findById(int id){
		log.debug("finding teacher_course instance by id");
		try{
			String hql = "from teacher_course c where c.teacher_courseID=:teacher_courseID";
			Query queryObject = getSession().createQuery(hql).setInteger("teacher_courseID", id); 
			return (teacher_course) queryObject.uniqueResult();
		}catch(RuntimeException re){
			log.error("find by id failed", re); 
			throw re;
		}
	}
	//通过教师id查找他的课
		public List findByTId(int id){
			log.debug("finding teacher_course instance by id");
			try{
				String hql = "from teacher_course c where c.teacher.teacherID=:teacherID";
				Query queryObject = getSession().createQuery(hql).setInteger("teacherID", id); 
				return queryObject.list();
			}catch(RuntimeException re){
				log.error("find by id failed", re); 
				throw re;
			}
		}
	//多条件，班级和年级
	public teacher_course findByClass(int grade, int jclass){
		log.debug("finding teacher_course instance by hql");
		try{
			String hql = "from class c where c.class=:class andc.grade=:grade";
			Query queryObject = getSession().createQuery(hql).setInteger("class", jclass).setInteger("grade", grade); 
			return (teacher_course) queryObject.uniqueResult();
		}catch(RuntimeException re){
			log.error("find by id failed", re); 
			throw re;
		}
	}
	//找到班级的平均成绩
	public double class_avg(int id){
		try{
			String sql = "call class_avg(:teacher_courseID)";
			Query queryObject = getSession().createSQLQuery(sql).setInteger("teacher_courseID", id); 
			return  (double)queryObject.uniqueResult();
		}catch(RuntimeException re){
			throw re;
		}
	}
	public void save(teacher_course instance) { 
		log.debug("saving teacher_course instance");
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
	public void update(teacher_course s) {
		log.debug("updating teacher_course instance");
		try{
			getSession().update(s);
			getSession().flush();
		}catch(RuntimeException re){
			log.error("update  failed", re); 
			throw re; 
		}
	} 
	//delete by id
	public void deleteById(int tid) {
		log.debug("deleting teacher_course by id");
		try{
			String hql = "delete teacher_course c where c.teacher_courseID=:teacher_courseID";
			Query queryObject = getSession().createQuery(hql).setInteger("teacher_courseID", tid); 
			queryObject.executeUpdate();
			getSession().flush();
		}catch(RuntimeException re){
			log.error("delete  failed", re); 
			throw re; 
		}
	}
}
