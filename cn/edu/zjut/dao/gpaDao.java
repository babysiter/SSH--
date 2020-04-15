package cn.edu.zjut.dao;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Query;

import cn.edu.zjut.po.Gpa;

public class gpaDao extends BaseHibernateDAO{
	private Log log = LogFactory.getLog(Gpa.class);
	//根据学号和学期查找某成绩
	public Gpa findBySTId(int id,String semester){
		log.debug("finding Gpa instance by id");
		try{
			String hql = "from Gpa c where c.ss.student.studentID=:studentID and c.ss.semester=:semester";
			Query queryObject = getSession().createQuery(hql).setInteger("studentID", id).setString("semester", semester); 
			return  (Gpa)queryObject.uniqueResult();
		}catch(RuntimeException re){
			log.error("find by id failed", re); 
			throw re;
		}
	}
	public void save(Gpa instance) { 
		log.debug("saving Gpa instance");
		try {
			getSession().persist(instance); 
			getSession().flush();
			log.debug("save successful"); 
		} catch (RuntimeException re) { 
			log.error("save failed", re); 
			throw re; 
		} 
		}
	//update 
	public void update(Gpa sc) {
		log.debug("updating Gpa instance");
		try{
			getSession().update(sc);
			getSession().flush();
		}catch(RuntimeException re){
			log.error("update  failed", re); 
			throw re; 
		}
	} 
	//delete by id and semester
	public void delete(int id,String semester) {
		log.debug("deleting Gpa instance");
		try{
			String hql = "delete Gpa c where where c.ss.student.studentID=:studentID and c.ss.semester=:semester";
			Query queryObject = getSession().createQuery(hql).setInteger("studentID", id).setString("semester", semester); 
			queryObject.executeUpdate();
			getSession().flush();
		}catch(RuntimeException re){
			log.error("delete  failed", re); 
			throw re; 
		}
	}
}