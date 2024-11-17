package com.cjc.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Student {
	@Id
	private Integer rollNo;
	private String name;
	private String address;
	private Long mno;

	public Integer getRollNo() {
		return rollNo;
	}

	public void setRollNo(Integer rollNo) {
		this.rollNo = rollNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Long getMno() {
		return mno;
	}

	public void setMno(Long mno) {
		this.mno = mno;
	}

	public Student(Integer rollNo, String name, String address, Long mno) {
		super();
		this.rollNo = rollNo;
		this.name = name;
		this.address = address;
		this.mno = mno;
	}

	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

}
