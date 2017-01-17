package com.automation;

import org.junit.Test;

import com.jayway.restassured.response.Response;

import static com.jayway.restassured.RestAssured.*;

public class RATest {

	@Test
	public void test1() {
		Response resp = given().contentType("application/json").when()
				.get("http://echo.getpostman.com/get");
		System.out.println("response" + resp.asString());
	}
}
