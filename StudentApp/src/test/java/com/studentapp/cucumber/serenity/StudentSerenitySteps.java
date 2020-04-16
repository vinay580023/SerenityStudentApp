package com.studentapp.cucumber.serenity;

import static org.hamcrest.Matchers.hasValue;
import static org.junit.Assert.assertThat;

import java.util.HashMap;
import java.util.List;

import com.serenityrestassured.model.StudentClass;
import com.studentapp.utils.ReusableSpecifications;

import io.restassured.http.ContentType;
import io.restassured.response.Validatable;
import io.restassured.response.ValidatableResponse;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

public class StudentSerenitySteps {

	@Step("Creating Student info by providing FirstName:{0},LastName:{1},Enmail{2},Programme{3],courses:{4}")
	public ValidatableResponse CreateStudent(String firstName,String lastName,String email,String programme,List<String>courses){
		
		StudentClass student = new StudentClass();
		//student.setid(101);
		student.setfirstName(firstName);
		student.setLastName(lastName);		
		student.setProgramme(programme);
		student.setEmail(email);
		student.setCourses(courses);
		
		return SerenityRest.rest().given()
		//.contentType(ContentType.JSON)
		.spec(ReusableSpecifications.getGenericrequestSpec())
		.log()
		.all()
		.when()
		.body(student)
		.post()
		.then();		
	}
	
	@Step("Getting the student information using FirstName:{0}")	
	public HashMap<String,Object> getStudentInfoUsingFirstName(String firstname){
		
		String p1 = "findAll{it.firstName=='";
		String p2 = "'}.get(0)";
		System.out.println("The Value is "+firstname);
		
		return SerenityRest.rest().given()
		.when()
		.get("/list")
		.then()		
		.extract()
		.path(p1+firstname+p2);
	}
	
	@Step("Update Student info by providing StudentId:{0},FirstName:{1},LastName:{2},Enmail{3},Programme{4],courses:{5}")
	public ValidatableResponse UpdateStudent(int studentid,String firstName,String lastName,String email,String programme,List<String>courses){
		
		StudentClass student = new StudentClass();
		//student.setid(101);
		student.setfirstName(firstName);
		student.setLastName(lastName);		
		student.setProgramme(programme);
		student.setEmail(email);
		student.setCourses(courses);	
		
		return SerenityRest.rest().given()
				//.contentType(ContentType.JSON)
				.spec(ReusableSpecifications.getGenericrequestSpec())
				.log()
				.all()
				.when()
				.body(student)
				.put("/"+studentid)
				.then()
				.log()
				.all();		
	}
	
	@Step("Get Student info by providing FirstName:{0}")
	public ValidatableResponse getStudentInfoByFirstName(String firstname){
	
		return SerenityRest.rest().given()
			   .when()
			   .get("/list")
			   .then()
			   .log()
			   .all()
			   .statusCode(200)
			   .extract()
			   .path(firstname);
	}
	
	@Step("Delete the Student Information by using StudentId:{0}")
	public void DeleteStudentInfo(int StudentId){
		
		SerenityRest.rest().given().when().delete("/"+StudentId);		 
	}
	
	@Step("Verify Student info is removed or not by using StudentId:{0}")
	public ValidatableResponse verifydeleteStudentInfo(int StudentId){
		 return SerenityRest.rest().given().when().get("/"+StudentId).then();
	}
}
