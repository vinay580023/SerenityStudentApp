package com.studentapp.utils;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import java.util.concurrent.TimeUnit;
import org.hamcrest.Matchers.*;



public class ReusableSpecifications {
	public static RequestSpecBuilder rspec;
	public static RequestSpecification RequestSpecification;
	
	public static ResponseSpecBuilder respec;
	public static ResponseSpecification ResponseSpecification;

	public static RequestSpecification getGenericrequestSpec(){
		
		rspec = new RequestSpecBuilder();
		rspec.setContentType(ContentType.JSON);
		RequestSpecification = rspec.build();
		return RequestSpecification;
		
	}
	
	public static ResponseSpecification getGenericResponse(){
		respec = new ResponseSpecBuilder();
		respec.expectHeader("Content-Type", "application/json;charset=UTF-8");
		respec.expectHeader("Transfer-Encoding", "chunked");
		//respec.expectResponseTime(lessThan(5L), TimeUnit.SECONDS);
		ResponseSpecification = respec.build();
		return ResponseSpecification;
	}


	
	
}



