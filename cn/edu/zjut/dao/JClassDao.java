package cn.edu.zjut.dao;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import cn.edu.zjut.po.JClass;
@Repository
public class JClassDao extends BaseHibernateDAO{
	private Log log = LogFactory.getLog(JClassDao.class);
	public List findAllJClass() {
		log.debug("finding JClass instance by hql"); 
		try {
			String queryString = "from JClass";
			Query queryObject = getSession().createQuery(queryString); 
			return queryObject.list(); 
			} catch (RuntimeException re) { 
				log.error("find by hql failed", re); 
				throw re; 
				} 
		}
	public JClass findById(int id){
		log.debug("finding JClass instance by id");
		try{
			String hql = "from JClass c where c.classID=:classID";
			Query queryObject = getSession().createQuery(hql).setInteger("classID", id); 
			return (JClass) queryObject.uniqueResult();
		}catch(RuntimeException re){
			log.error("find by id failed", re); 
			throw re;
		}
	}
	//多条件，班级和年级和专业
	public JClass findByClass(int grade, int JClass,String majorName){
		log.debug("finding JClass instance by hql");
		try{
			String hql = "from JClass c where c.ClassNumber=:class and c.grade=:grade and c.major.majorName=:majorName";
			Query queryObject = getSession().createQuery(hql).setInteger("class", JClass).setInteger("grade", grade).setString("majorName", majorName); 
			return (JClass) queryObject.uniqueResult();
		}catch(RuntimeException re){
			log.error("find by id failed", re); 
			throw re;
		}
	}
	public void save(JClass instance) { 
		log.debug("saving JClass instance");
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
	public void update(int change_grade,int change_class, int grade, int jclass) {
		log.debug("updating JClass instance");
		try{
			String queryString = "update JClass a set a.ClassNumber=:change_class,a.grade=:change_grade where a.ClassNumber=:class and a.grade =:grade";
			Query queryObject = getSession().createQuery(queryString); 
			queryObject.setInteger("change_grade",change_grade);
			queryObject.setInteger("change_class",change_class);
			queryObject.setInteger("class",jclass);
			queryObject.setInteger("grade",grade);
			queryObject.executeUpdate();
			getSession().flush();
		}catch(RuntimeException re){
			log.error("update  failed", re); 
			throw re; 
		}
	} 
	//delete by acccount
	public void delete(int grade, int jclass) {
		log.debug("deleting JClass instance");
		try{
			String queryString = "delete JClass a where a.ClassNumber =:class and a.grade =:grade";
			Query queryObject = getSession().createQuery(queryString); 
			queryObject.setInteger("class",jclass);
			queryObject.setInteger("grade",grade);
			queryObject.executeUpdate();
			getSession().flush();
		}catch(RuntimeException re){
			log.error("delete  failed", re); 
			throw re; 
		}
	}
}
