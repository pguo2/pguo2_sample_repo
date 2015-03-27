package com.pguo.hibernate.collections.list;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class ShowroomService {

private SessionFactory sessionFactory;
	
	public ShowroomService(){
		init();
	}
	
	public void init(){
		Configuration config = new Configuration().configure("com/pguo/hibernate/collections/list/hibernate.cfg.xml");
		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(
				config.getProperties()).build();
		sessionFactory = config.buildSessionFactory(serviceRegistry);
	}
	
	public void save(Showroom showroom) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.getTransaction();
		tx.begin();
		session.save(showroom);
		System.out.println("actual list class: " + showroom.getCars().getClass().getName());
		tx.commit();
		session.close();
	}
	
	public void remove(Showroom showroom) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.getTransaction();
		tx.begin();
		session.delete(showroom);
		tx.commit();
		session.close();
	}
	
	public static void main(String[] args) {
		Showroom showroom = new Showroom();
		showroom.setId(3);
		new ShowroomService().remove(showroom);
//		Car car1 = new Car();
//		car1.setColor("Black");
//		car1.setName("BMW");
//		
//		Car car2 = new Car();
//		car2.setColor("Racing Green");
//		car2.setName("Toyota");
//		
//		List<Car> cars = new ArrayList<Car>();
//		cars.add(car1);
//		cars.add(car2);
//		
//		Showroom showroom = new Showroom();
//		showroom.setManager("Barry Larry");
//		showroom.setLocation("East Croydon, Greater London");
//		showroom.setCars(cars);
//		
//		new ShowroomService().save(showroom);
	}

}
