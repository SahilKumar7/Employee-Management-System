package com.project.ems;

public class Employee {
	private int id;
	private String name;
	private String email;
	
	public Employee() {
//		this.id = id;
//		this.name = name;
//		this.email = email;
	}
	
	public int getId() {
		return this.id;	
	}
	
	public String getName() {
		return this.name;
	}
	
	public String getEmail() {
		return this.email;
	}
	
	public void setId(int id) { 
		this.id = id;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
}
