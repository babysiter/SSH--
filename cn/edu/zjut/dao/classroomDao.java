package cn.edu.zjut.dao;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import cn.edu.zjut.po.Classroom;
@Repository
public class classroomDao extends BaseHibernateDAO{
	private Log log = LogFactory.getLog(classroomDao.class);
	public List findAllclassroom() {
		log.debug("finding classroom instance by hql"); 
		try {
			String queryString = "from Classroom";
			Query queryObject = getSession().createQuery(queryString); 
			return queryObject.list(); 
			} catch (RuntimeException re) { 
				log.error("find by hql failed", re); 
				throw re; 
				} 
		}
	public Classroom findById(int id){
		log.debug("finding classroom instance by id");
		try{
			String hql = "from Classroom c where c.classroomID=:classroomID";
			Query queryObject = getSession().createQuery(hql).setInteger("classroomID", id); 
			return (Classroom) queryObject.uniqueResult();
		}catch(RuntimeException re){
			log.error("find by id failed", re); 
			throw re;
		}
	}
	public void save(Classroom instance) { 
		log.debug("saving classroom instance");
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
	public void update(Classroom s) {
		log.debug("updating Classroom instance");
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
		log.debug("deleting classroom instance");
		try{
			String queryString = "delete Classroom a where a.classroomID=:classroomID";
			Query queryObject = getSession().createQuery(queryString); 
			queryObject.setInteger("classroomID",s);
			queryObject.executeUpdate();
			getSession().flush();
		}catch(RuntimeException re){
			log.error("delete  failed", re); 
			throw re; 
		}
	}
}
