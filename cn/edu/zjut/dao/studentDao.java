package cn.edu.zjut.dao;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import cn.edu.zjut.po.student;
@Repository
public class studentDao extends BaseHibernateDAO{
	private Log log = LogFactory.getLog(studentDao.class);
	public List findAllstudent() {
		log.debug("finding student instance by hql"); 
		try {
			String queryString = "from student";
			Query queryObject = getSession().createQuery(queryString); 
			return queryObject.list(); 
			} catch (RuntimeException re) { 
				log.error("find by hql failed", re); 
				throw re; 
				} 
		}
	public student findById(int id){
		log.debug("finding student instance by id");
		try{
			String hql = "from student c where c.studentID=:studentID";
			Query queryObject = getSession().createQuery(hql).setInteger("studentID", id); 
			return (student) queryObject.uniqueResult();
		}catch(RuntimeException re){
			log.error("find by id failed", re); 
			throw re;
		}
	}
	public student findByAccount(String account){
		log.debug("finding student instance by account");
		try{
			String hql = "from student c where c.account=:account";
			Query queryObject = getSession().createQuery(hql).setString("account", account); 
			return (student) queryObject.uniqueResult();
		}catch(RuntimeException re){
			log.error("find by id failed", re); 
			throw re;
		}
	}
	public void save(student instance) { 
		log.debug("saving student instance");
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
	public void update(student s) {
		log.debug("updating student instance");
		try{
			getSession().update(s);
			getSession().flush();
		}catch(RuntimeException re){
			log.error("update  failed", re); 
			throw re; 
		}
	} 
	//delete by acccount
	public void delete(int sid) {
		log.debug("deleting student instance");
		try{
			String hql = "delete student c where c.studentID=:studentID";
			Query queryObject = getSession().createQuery(hql).setInteger("studentID",sid); 
			queryObject.executeUpdate();
			getSession().flush();
		}catch(RuntimeException re){
			log.error("delete  failed", re); 
			throw re; 
		}
	}
}
