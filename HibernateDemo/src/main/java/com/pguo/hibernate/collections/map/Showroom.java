package com.pguo.hibernate.collections.map;

import java.util.Map;

public class Showroom {

	private int id = 0;
	
	private String manager = null;
	
	private String location = null;
	
	private Map<String,Car> cars = null;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getManager() {
		return manager;
	}

	public void setManager(String manager) {
		this.manager = manager;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Map<String,Car> getCars() {
		return cars;
	}

	public void setCars(Map<String,Car> cars) {
		this.cars = cars;
	}

}
