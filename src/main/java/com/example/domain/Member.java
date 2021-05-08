package com.example.domain;

public class Member {
	//private Integer id;
	private String name;
	//private Integer age;
	//private Integer depId;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return  name ;
	}
	
	
	
}
