package com.njq.nongfadai.instance;

import java.io.Serializable;

public class UserInstance implements Serializable {
	public UserInstance() {
		System.out.println("%%%%UserInstance construct");
	}

	private Integer id;
	
	private String userName;
	
	private int age;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "UserInstance [id=" + id + ", userName=" + userName + ", age=" + age + "]";
	}
	
}
