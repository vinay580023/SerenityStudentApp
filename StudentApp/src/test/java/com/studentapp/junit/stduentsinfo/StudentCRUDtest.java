package com.studentapp.junit.stduentsinfo;

import java.util.ArrayList;
import java.util.HashMap;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;

import com.serenityrestassured.model.StudentClass;
import com.studentapp.cucumber.serenity.StudentSerenitySteps;
import com.studentapp.testbase.TestBase;
import com.studentapp.utils.ReusableSpecifications;
import com.studentapp.utils.TestUtils;

import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

@RunWith(SerenityRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class StudentCRUDtest extends TestBase {

static String firstname = "SomkeUser"+TestUtils.getRandomString();
static String lastname = "SmokeUser"+TestUtils.getRandomString();
static String email = TestUtils.getRandomString()+"xyz@gmail.com";
static String programme = "ComputerScience";
static int studentId;

@Steps
StudentSerenitySteps Steps;

	@Title("Create a New Student")
	@Test
	public void test001(){
	
		ArrayList<String> courses = new ArrayList<String>();
		courses.add("JAVA");
		courses.add("C++");
		
		Steps.CreateStudent(firstname, lastname, email, programme, courses).statusCode(201).spec(ReusableSpecifications.getGenericResponse());
		
	/*	
		StudentClass student = new StudentClass();
		//student.setid(101);
		student.setfirstName(firstname);
		student.setLastName(lastname);		
		student.setProgramme(programme);
		student.setEmail(email);
		student.setCourses(courses);
		
		System.out.println("Request Body"+student);
		SerenityRest.rest().given()
		.contentType(ContentType.JSON)
		.when()
		.body(student)
		.post()
		.then()
		.log()
		.all()
		.statusCode(201);
		*/
	}
	
	@Title("Verifying-Student was added to the application")
	@Test
	public void test002(){
		/*
		String p1 = "findAll{it.firstName=='";
		String p2 = "'}.get(0)";
		System.out.println("The Value is "+firstname);
		*/
		HashMap<String,Object> Value = Steps.getStudentInfoUsingFirstName(firstname);
		/*
		HashMap<String,Object> Value = SerenityRest.rest().given()
		.when()
		.get("/list")
		.then()
		.log()
		.all()
		.statusCode(200)
		.extract()
		.path(p1+firstname+p2);
		System.out.println("The Value is "+Value);
		*/
		assertThat(Value,hasValue(firstname));
		studentId = (int)Value.get("id");
	}

	@Title("Update Student details and verify updated details")
	@Test
	public void test003(){
		ArrayList<String> courses = new ArrayList<String>();
		courses.add("JAVA");
		courses.add("C++");
		
		firstname = firstname+"_Updated";
		
		Steps.UpdateStudent(studentId,firstname, lastname, email, programme, courses).statusCode(200);
	/*
		StudentClass student = new StudentClass();
		//student.setid(101);
		student.setfirstName(firstName);
		student.setLastName(lastName);		
		student.setProgramme(programme);
		student.setEmail(email);
		student.setCourses(courses);
		
		System.out.println("Request Body"+student);
		SerenityRest.rest().given()
		.contentType(ContentType.JSON)
		.log()
		.all()
		.when()
		.body(student)
		.put("/"+studentId)
		.then()
		.log()
		.all();
		
		//Verifying updated details
		 * 
		String p1 = "findAll{it.firstName=='";
		String p2 = "'}.get(0)";
		System.out.println("The Value is "+firstname);
		
		 SerenityRest.rest().given()
			   .when()
			   .get("/list")
			   .then()
			   .log()
			   .all()
			   .statusCode(200)
			   .extract()
			   .path(firstname);
		*/
		
		//Verifying updated details	
		
		HashMap<String,Object> Value = Steps.getStudentInfoUsingFirstName(firstname);
		assertThat(Value,hasValue(firstname));
	}

	@Title("Delete Student Details and verify student is deleted")
	@Test
	public void test004(){
	
		Steps.DeleteStudentInfo(studentId);
		Steps.verifydeleteStudentInfo(studentId).statusCode(404);
		/*
		SerenityRest
		.rest()
		.given()
		.when()
		.delete("/"+studentId);
		
		 SerenityRest
		.rest()
		.given()
		.when()
		.get("/"+studentId)
		.then()
		.log()
		.all()
		.statusCode(404);
		*/
	}
	
}
