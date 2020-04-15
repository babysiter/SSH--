package cn.edu.zjut.dao;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import cn.edu.zjut.po.major;
@Repository
public class majorDao extends BaseHibernateDAO{
	private Log log = LogFactory.getLog(majorDao.class);
	public List findAllmajor() {
		log.debug("finding major instance by hql"); 
		try {
			String queryString = "from major";
			Query queryObject = getSession().createQuery(queryString); 
			return queryObject.list(); 
			} catch (RuntimeException re) { 
				log.error("find by hql failed", re); 
				throw re; 
				} 
		}
	public major findById(int id){
		log.debug("finding major instance by id");
		try{
			String hql = "from major c where c.majorID=:majorID";
			Query queryObject = getSession().createQuery(hql).setInteger("majorID", id); 
			return (major) queryObject.uniqueResult();
		}catch(RuntimeException re){
			log.error("find by id failed", re); 
			throw re;
		}
	}
	public major findByName(String majorName){
		log.debug("finding major instance by hql");
		try{
			String hql = "from major c where c.majorName=:majorName";
			Query queryObject = getSession().createQuery(hql).setString("majorName", majorName); 
			return (major) queryObject.uniqueResult();
		}catch(RuntimeException re){
			log.error("find by id failed", re); 
			throw re;
		}
	}
	public void save(major instance) { 
		log.debug("saving major instance");
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
	public void update(String name,String instance) {
		log.debug("updating major instance");
		try{
			String queryString = "update major a set a.majorName=:name where a.majorName=:collegeID";
			Query queryObject = getSession().createQuery(queryString); 
			queryObject.setString("name",name);
			queryObject.setString("collegeID",instance);
			queryObject.executeUpdate();
			getSession().flush();
		}catch(RuntimeException re){
			log.error("update  failed", re); 
			throw re; 
		}
	} 
	//delete by acccount
	public void delete(String instance) {
		log.debug("deleting major instance");
		try{
			String queryString = "delete major a where a.majorName=:majorName";
			Query queryObject = getSession().createQuery(queryString); 
			queryObject.setString("majorName",instance);
			queryObject.executeUpdate();
			getSession().flush();
		}catch(RuntimeException re){
			log.error("delete  failed", re); 
			throw re; 
		}
	}
}
