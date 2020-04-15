package cn.edu.zjut.dao;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import cn.edu.zjut.po.course;
@Repository
public class courseDao extends BaseHibernateDAO{
	private Log log = LogFactory.getLog(courseDao.class);
	public List findAllcourse() {
		log.debug("finding course instance by hql"); 
		try {
			String queryString = "from course";
			Query queryObject = getSession().createQuery(queryString); 
			return queryObject.list(); 
			} catch (RuntimeException re) { 
				log.error("find by hql failed", re); 
				throw re; 
				} 
		}
	public course findById(int id){
		log.debug("finding course instance by id");
		try{
			String hql = "from course c where c.courseID=:courseID";
			Query queryObject = getSession().createQuery(hql).setInteger("courseID", id); 
			return (course) queryObject.uniqueResult();
		}catch(RuntimeException re){
			log.error("find by id failed", re); 
			throw re;
		}
	}
	public void save(course instance) { 
		log.debug("saving course instance");
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
	public void update(course s) {
		log.debug("updating course instance");
		try{
			getSession().update(s);
			getSession().flush();
		}catch(RuntimeException re){
			log.error("update  failed", re); 
			throw re; 
		}
	} 
	//delete by acccount
	public void delete(int s) {
		log.debug("deleting course instance");
		try{
			String queryString = "delete course a where a.courseID=:courseID";
			Query queryObject = getSession().createQuery(queryString); 
			queryObject.setInteger("courseID",s);
			queryObject.executeUpdate();
			getSession().flush();
		}catch(RuntimeException re){
			log.error("delete  failed", re); 
			throw re; 
		}
	}
}
