package Automate_WebServices_RestAPI;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class Get_Json_Response_As_String {
	@Test
	public void query_parameter1() {

		Response res = given().baseUri("https://jsonplaceholder.typicode.com").queryParam("postId", 1).when()
				.get("/comments");

	//	System.out.println(res.asPrettyString()); 
		System.out.println(res.asString()); 

	}

	@Test
	public void verify_contentType_json() {

		String email = given().baseUri("https://jsonplaceholder.typicode.com").queryParam("postId", 1).when()
				.get("/comments").then().contentType(ContentType.JSON).extract().path("[0].email");

			System.out.println("EMAIL :"+email); 

	}
}