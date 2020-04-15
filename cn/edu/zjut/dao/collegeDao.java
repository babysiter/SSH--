package cn.edu.zjut.dao;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import cn.edu.zjut.po.college;
@Repository
public class collegeDao extends BaseHibernateDAO{
	private Log log = LogFactory.getLog(collegeDao.class);
	public List findByHql(String hql) {
		log.debug("finding college instance by hql"); 
		try {
			String queryString = hql;
			Query queryObject = getSession().createQuery(queryString); 
			return queryObject.list(); 
			} catch (RuntimeException re) { 
				log.error("find by hql failed", re); 
				throw re; 
				} 
		}
	public List findAllcollege() {
		log.debug("finding college instance by hql"); 
		try {
			String queryString = "from college";
			Query queryObject = getSession().createQuery(queryString); 
			return queryObject.list(); 
			} catch (RuntimeException re) { 
				log.error("find by hql failed", re); 
				throw re; 
				} 
		}
	public college findById(int id){
		log.debug("finding college instance by id");
		try{
			String hql = "from college c where c.collegeID=:collegeID";
			Query queryObject = getSession().createQuery(hql).setInteger("collegeID", id); 
			return (college) queryObject.uniqueResult();
		}catch(RuntimeException re){
			log.error("find by id failed", re); 
			throw re;
		}
	}
	public college findByAccount(String account){
		log.debug("finding college instance by hql");
		try{
			String hql = "from college c where c.account=:account";
			Query queryObject = getSession().createQuery(hql).setString("account", account); 
			return (college) queryObject.uniqueResult();
		}catch(RuntimeException re){
			log.error("find by id failed", re); 
			throw re;
		}
	}
	public void save(college instance) { 
		log.debug("saving college instance");
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
		log.debug("updating college instance");
		try{
			String queryString = "update college a set a.college_name=:collegeName where a.college_name=:collegeID";
			Query queryObject = getSession().createQuery(queryString); 
			queryObject.setString("collegeName",name);
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
		log.debug("deleting college instance");
		try{
			String queryString = "delete college a where a.college_name=:collegeID";
			Query queryObject = getSession().createQuery(queryString); 
			queryObject.setString("collegeID",instance);
			queryObject.executeUpdate();
			getSession().flush();
		}catch(RuntimeException re){
			log.error("delete  failed", re); 
			throw re; 
		}
	}
}
