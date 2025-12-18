package Automate_WebServices_RestAPI;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class Verify_ContentType_And_Find_Path {

	@Test
	public void verify_contentType_json() {

		String email = given().baseUri("https://jsonplaceholder.typicode.com").queryParam("postId", 1).when()
				.get("/comments").then().contentType(ContentType.JSON).extract().path("[0].email");

		System.out.println("EMAIL :" + email);

	}

	@Test
	public void verify_contentType_json_and_path() {

		Response res = given().baseUri("https://jsonplaceholder.typicode.com").queryParam("postId", 1).when()
				.get("/comments");
		String ActualEmailID = res.then().contentType(ContentType.JSON).extract().path("[0].email");

		String ExpectedEmailID = "";

		if (ActualEmailID.equals(ExpectedEmailID)) {
			System.out.println("Test Passed");
		} else {
			System.out.println("Test Passed");
		}

	}
}