package com.studentapp.junit.stduentsinfo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;


import io.restassured.RestAssured;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Manual;
import net.thucydides.core.annotations.Pending;
import net.thucydides.core.annotations.Title;

@RunWith(SerenityRunner.class)
public class FirstSerenityTest {
	
@BeforeClass
	public static void init(){
		
		RestAssured.baseURI="http://localhost:8080/student";
	}	
	@Test
	public void getAllStudents(){
		
		SerenityRest.given()
		.when()
		.get("/list")
		.then()
		.log()
		.all()
		.statusCode(200);
	}
	
	@Test
	public void thisisfailingtest(){
		
		SerenityRest.given()
		.when()
		.get("/list")
		.then()
		.log()
		.all()
		.statusCode(500);
	}
	
	@Pending
	@Test
	public void thisisaPendingTest(){
		
	}
	
	@Ignore
	@Test
	public void thisisaSkippedTest(){
		
	}	
	
	@Test
	public void thisisatestwithError(){
		System.out.println("This is a error"+(5/0));
	}
	
	@Test
	public void filedoesnotexist() throws FileNotFoundException{
		File file = new File("E://File.txt");
		FileReader Fr = new FileReader(file);
		System.out.println(Fr);
	}
	
	@Manual
	@Test
	public void thisismanualtest(){
		
	}
	
	@Title("This test will get info of all the students")
	@Test
	public void test01(){
		
		SerenityRest.given()
		.when()
		.get("/list")
		.then()
		.log()
		.all()
		.statusCode(200);
	}
}
