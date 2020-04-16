package com.studentapp.junit.stduentsinfo;

import org.junit.Test;

import com.studentapp.testbase.TestBase;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Title;
import net.thucydides.core.annotations.WithTag;
import net.thucydides.core.annotations.WithTags;

public class TagsTest extends TestBase{

	@WithTag("studentfeature:NEGATIVE")
	@Title("Verifying status code by passing invalid HTTP post request to source")
	@Test
	public void InvalidMethod(){
		
		SerenityRest.rest()
		.given()
		.when()
		.post("/list")
		.then()
		.statusCode(405);
	}
	
	@WithTags
	(
		{
			@WithTag("studentfeature:POSITIVE"),
			@WithTag("studentfeature:SMOKE")
	    }
	)
	@Title("Verifying valid get method status code 200 by sending valid get request")
	@Test
	public void validmethod(){
		
		SerenityRest.rest()
		.when()
		.get("/list")
		.then()
		.statusCode(200);
		
	}
	
	@WithTags
	(
		{
			@WithTag("studentfeature:NEGATIVE"),
			@WithTag("studentfeature:SMOKE")
	    }
	)
	@Title("Verifying status code 400 by sending invalid get Request")
	@Test
	public void invalidget(){
		
		SerenityRest.rest()
		.when()
		.get("/listghf")
		.then()
		.statusCode(400);
	}
}
