package com.studentapp.junit.stduentsinfo;

import java.util.ArrayList;

import org.junit.Test;
import org.junit.runner.RunWith;

import com.studentapp.cucumber.serenity.StudentSerenitySteps;
import com.studentapp.testbase.TestBase;

import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import net.thucydides.junit.annotations.Concurrent;
import net.thucydides.junit.annotations.UseTestDataFrom;

@Concurrent(threads="4x")
@UseTestDataFrom("C:\\Users\\mindtree609\\API\\StudentApp\\src\\test\\resources\\testdata\\studentinfo.csv")
@RunWith(SerenityParameterizedRunner.class)
public class CreateStudentsDataDriven extends TestBase{

	private String firstName;
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getProgramme() {
		return programme;
	}
	public void setProgramme(String programme) {
		this.programme = programme;
	}
	public StudentSerenitySteps getSteps() {
		return steps;
	}
	public void setSteps(StudentSerenitySteps steps) {
		this.steps = steps;
	}
	private String lastName;
	private String email;
	private String programme;
		
	@Steps
	StudentSerenitySteps steps;
	@Title("Data Driven Test for adding multiple Students to Student App.")
	@Test
	public void CreateMultiplestudents(){
		ArrayList<String> courses = new ArrayList<String>();		
		courses.add("JAVA");	
		courses.add("C#");
		steps.CreateStudent(firstName, lastName, email, programme, courses).statusCode(201);
		
	}
}
