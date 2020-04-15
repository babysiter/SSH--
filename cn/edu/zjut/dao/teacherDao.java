package cn.edu.zjut.dao;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import cn.edu.zjut.po.student;
import cn.edu.zjut.po.teacher;
@Repository
public class teacherDao extends BaseHibernateDAO{
	private Log log = LogFactory.getLog(teacherDao.class);
	public List findAllteacher() {
		log.debug("finding teacher instance by hql"); 
		try {
			String queryString = "from teacher";
			Query queryObject = getSession().createQuery(queryString); 
			return queryObject.list(); 
			} catch (RuntimeException re) { 
				log.error("find by hql failed", re); 
				throw re; 
				} 
		}
	public teacher findById(int id){
		log.debug("finding teacher instance by id");
		try{
			String hql = "from teacher c where c.teacherID=:teacherID";
			Query queryObject = getSession().createQuery(hql).setInteger("teacherID", id); 
			return (teacher) queryObject.uniqueResult();
		}catch(RuntimeException re){
			log.error("find by id failed", re); 
			throw re;
		}
	}
	public teacher findByAccount(String account){
		log.debug("finding teacher instance by account");
		try{
			String hql = "from teacher c where c.account=:teacherAccount";
			Query queryObject = getSession().createQuery(hql).setString("teacherAccount", account); 
			return (teacher) queryObject.uniqueResult();
		}catch(RuntimeException re){
			log.error("find by id failed", re); 
			throw re;
		}
	}
	public void save(teacher instance) { 
		log.debug("saving teacher instance");
		try {
			System.out.println(instance.toString());
			getSession().merge(instance); 
			getSession().flush();
			log.debug("save successful"); 
		} catch (RuntimeException re) { 
			log.error("save failed", re); 
			throw re; 
		} 
		}
	//update by name
	public void update(teacher s) {
		log.debug("updating teacher instance");
		try{
			getSession().merge(s);
			getSession().flush();
		}catch(RuntimeException re){
			log.error("update  failed", re); 
			throw re; 
		}
	} 
	//delete by acccount
	public void delete(int tid) {
		log.debug("deleting teacher instance");
		try{
			String hql = "delete teacher c where c.teacherID=:teacherID";
			Query queryObject = getSession().createQuery(hql).setInteger("teacherID",tid); 
			queryObject.executeUpdate();
			getSession().flush();
		}catch(RuntimeException re){
			log.error("delete  failed", re); 
			throw re; 
		}
	}
}
