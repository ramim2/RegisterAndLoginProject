package com.techpalle.model;

public class Customer 
{
	private int id;
	private String name;
	private String email;
	private long mobile;
	private String state;
	private String password;
public Customer(String name,String email, long mobile, String state, String password) 
{
		super();
		this.name = name;
		this.email = email;
		this.mobile = mobile;
		this.state = state;
		this.password = password;
	}
public int getId() 
{
	return id;
}
public void setId(int id) 
{
	this.id = id;
}
public String getName() 
{
	return name;
}
public void setName(String name) 
{
	this.name = name;
}
public String getEmail() 
{
	return email;
}
public void setEmail(String email) 
{
	this.email = email;
}
public long getMobile() {
	return mobile;
}
public void setMobile(long mobile) 
{
	this.mobile = mobile;
}
public String getState() {
	return state;
}
public void setState(String state) {
	this.state = state;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
}
