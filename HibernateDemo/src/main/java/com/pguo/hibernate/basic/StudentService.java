package com.pguo.hibernate.basic;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class StudentService {
	
	private SessionFactory sessionFactory;
	
	public StudentService(){
		init();
	}
	
	public void init(){
		Configuration config = new Configuration().configure("com/pguo/hibernate/basic/hibernate.cfg.xml");
		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(
				config.getProperties()).build();
		sessionFactory = config.buildSessionFactory(serviceRegistry);
	}
	
	
	public void save(Student student){
//		Session session = sessionFactory.getCurrentSession();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(student);
		session.getTransaction().commit();
	}
	
	public void remove(Student student){
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.delete(student);
		session.getTransaction().commit();
	}
	
	public static void main(String[] args) {
	   Student student = new Student();
//	   student.setId(4);
	   student.setFirstName("xiaowei");
	   student.setLastName("Li");
	   student.setYearLevel(5);
	   
       new StudentService().save(student);
       
//       new StudentService().remove(student);
	}

}
