package com.pguo.hibernate.collections.map;

import java.util.HashMap;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class ShowroomService {

	private SessionFactory sessionFactory;

	public ShowroomService() {
		init();
	}

	public void init() {
		Configuration config = new Configuration()
				.configure("com/pguo/hibernate/collections/map/hibernate.cfg.xml");
		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
				.applySettings(config.getProperties()).build();
		sessionFactory = config.buildSessionFactory(serviceRegistry);
	}

	public void save(Showroom showroom) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.getTransaction();
		tx.begin();
		session.save(showroom);
		System.out.println("actual list class: "
				+ showroom.getCars().getClass().getName());
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
//		Showroom showroom = new Showroom();
//		showroom.setId(3);
//		new ShowroomService().remove(showroom);

		Showroom showroom = new Showroom();
		showroom.setLocation("East Croydon, Greater London");
		showroom.setManager("Cherry Flurry");
		
		Map<String, Car> cars = new HashMap<String, Car>();
		cars.put("barry", new Car("Toyota", "Racing Green"));
		cars.put("larry", new Car("Nissan", "White"));
		cars.put("harry", new Car("BMW", "Black"));

		showroom.setCars(cars);
		
		new ShowroomService().save(showroom);
	}
}
