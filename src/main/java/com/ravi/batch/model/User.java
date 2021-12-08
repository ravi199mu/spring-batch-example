package com.ravi.batch.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class User {

	@Id
	private Integer id;
	
	private String name;
	private String dept;
	private Integer salary;
	private Date timeStamp;
	
	public User() {
	}

	public User(Integer id, String name, String dept, Integer salary,Date time) {
		this.id = id;
		this.name = name;
		this.dept = dept;
		this.salary = salary;
		timeStamp = time;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public Integer getSalary() {
		return salary;
	}

	public void setSalary(Integer salary) {
		this.salary = salary;
	}
	
	

	public Date getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(Date timeStamp) {
		this.timeStamp = timeStamp;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", dept=" + dept + ", salary=" + salary + ", timeStamp="
				+ timeStamp + "]";
	}

	

	
	
}
