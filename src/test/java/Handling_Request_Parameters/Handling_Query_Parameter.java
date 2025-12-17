package Handling_Request_Parameters;

import static io.restassured.RestAssured.given;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.response.Response;

public class Handling_Query_Parameter {
	
	@Test
	public void query_parameter1() {

		given()
			.baseUri("https://simple-grocery-store-api.glitch.me")
			.param("category", "coffee")
			.param("results", 10).
		when()
			.get("/status").
		then()
			.log().all()
			.statusCode(200);

	}
	
	
	@Test
	public void query_parameter2() {

		given()
			.baseUri("https://simple-grocery-store-api.glitch.me")
			.queryParam("category", "coffee")
			.queryParam("results", 10).
		when()
			.get("/status").
		then()
			.log().all()
			.statusCode(200);
	}
	
	@Test
	public void multiple_query_parameter() {

		given()
			.baseUri("https://simple-grocery-store-api.glitch.me")
			.queryParam("category", "coffee")
			.queryParam("results", 10).
		when()
			.get("/status").
		then()
			.log().all()
			.statusCode(200);
	}
	
	@Test
	public void multiple_query_parameters_using_hashmap() {
		
		HashMap<String, Object> hmap = 	new HashMap<String, Object>();
		hmap.put("category", "coffee");
		hmap.put("results", 10);

		given()
			.baseUri("https://simple-grocery-store-api.glitch.me")
			.queryParams(hmap).
		when()
			.get("/status").
		then()
			.log().all()
			.statusCode(200);
	}
	
	@Test
	public void multi_value_parameters() {
		
		given()
			.baseUri("https://simple-grocery-store-api.glitch.me")
			.queryParams("category","col,no,ee,in").
		when()
			.get("/status").
		then()
			.log().all()
			.statusCode(200);
	}
}
