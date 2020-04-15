package cn.edu.zjut.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext; 
public class HibernateUtil { 
	private static ApplicationContext applicationContext;
	private static final ThreadLocal<Session> threadLocal = new ThreadLocal<Session>();
	private static org.hibernate.SessionFactory sessionFactory; 
	static { 
		try { 
			applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
			sessionFactory = (SessionFactory) applicationContext.getBean("sessionFactory");
		}catch (Exception e) { 
			System.err .println("%%%% Error Creating SessionFactory %%%%"); 
			e.printStackTrace(); 
		} 
	}
	
	private HibernateUtil() { } 
	public static org.hibernate.SessionFactory getSessionFactory() { 
		return sessionFactory; 
	}
	public static void rebuildSessionFactory() { 
		try {
			sessionFactory = (SessionFactory) applicationContext.getBean("sessionFactory"); 
		} catch (Exception e) { 
			System.err .println("%%%% Error Creating SessionFactory %%%%"); 
			e.printStackTrace(); 
		} 
	}
	
	
	
	public static Session getSession() throws HibernateException {
		Session session = (Session) threadLocal.get(); 
		if (session == null || !session.isOpen()) { 
			if (sessionFactory == null) 
				rebuildSessionFactory(); 
			session = (sessionFactory != null) ? sessionFactory.openSession(): null; 
			threadLocal.set(session); 
		}
		return session; 
	}
	//sessionFactory.getCurrentSession，会自动关闭
	public static void closeSession() throws HibernateException { 
		Session session = (Session) threadLocal.get(); 
		threadLocal.set(null); 
		if (session != null) { 
			session.close(); 
		} 
	} 
	
}