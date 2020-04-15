package cn.edu.zjut.dao;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import cn.edu.zjut.po.admin;
@Repository
public class adminDao extends BaseHibernateDAO{
	private Log log = LogFactory.getLog(adminDao.class);
	public List findAlladmin() {
		log.debug("finding admin instance by hql"); 
		try {
			String queryString = "from admin";
			Query queryObject = getSession().createQuery(queryString); 
			return queryObject.list(); 
			} catch (RuntimeException re) { 
				log.error("find by hql failed", re); 
				throw re; 
				} 
		}
	public admin findById(int id){
		log.debug("finding admin instance by id");
		try{
			String hql = "from admin c where c.adminID=:adminID";
			Query queryObject = getSession().createQuery(hql).setInteger("adminID", id); 
			return (admin) queryObject.uniqueResult();
		}catch(RuntimeException re){
			log.error("find by id failed", re); 
			throw re;
		}
	}
	public admin findByAccount(String account){
		log.debug("finding admin instance by hql");
		try{
			String hql = "from admin c where c.account=:account";
			Query queryObject = getSession().createQuery(hql).setString("account", account); 
			return (admin) queryObject.uniqueResult();
		}catch(RuntimeException re){
			log.error("find by id failed", re); 
			throw re;
		}
	}
	public void save(admin instance) { 
		log.debug("saving admin instance");
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
	public void update(admin instance) {
		log.debug("updating admin instance");
		try{
			getSession().update(instance); 
			getSession().flush();
		}catch(RuntimeException re){
			log.error("update  failed", re); 
			throw re; 
		}
		
	} 
	//delete by acccount
	public void delete(int instance) {
		log.debug("deleting admin instance");
		try{
			String queryString = "delete admin a where a.adminID=:adminID";
			Query queryObject = getSession().createQuery(queryString); 
			queryObject.setInteger("adminID",instance);
			queryObject.executeUpdate();
			getSession().flush();
		}catch(RuntimeException re){
			log.error("delete  failed", re); 
			throw re; 
		}
	}
}
