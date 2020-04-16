package com.serenityrestassured.model;

import java.util.ArrayList;
import java.util.List;

public class StudentClass {

	private int id ;
	private String firstName;
	private String lastName;
	private String email;
	private String programme;
	private List<String> courses;
	
	public int getid(){
		return id;
	}
	
	public void setid(int id){
		this.id = id;
	}
	
	public String getFirstName(){
		return firstName;
	}
	
	public void setfirstName(String firstname){
		this.firstName = firstname;
		System.out.println("FirstName:= "+firstname);
	}
	
	public String getLastName(){
		return lastName;
	}
	
	public void setLastName(String lastName){
		this.lastName = lastName;
		System.out.println("Last Name:= "+lastName);
	}
	
	public String getEmail(){
		return email;
	}
	
	public void setEmail(String email){
		this.email = email;
		System.out.println("Email := "+email);
	}
	
	public String getProgramme(){
		return programme;
	}
	
	public void setProgramme(String programme){
		this.programme = programme;
		System.out.println("programme := "+programme);
	}
	
	public void setCourses(List<String> courses){
		this.courses = courses; 
	}
}
