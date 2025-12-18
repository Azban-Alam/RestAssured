package Automate_WebServices_RestAPI;

import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class Query_Parameter {
	@Test
	public void query_parameter1() {

		Response res = given().baseUri("https://jsonplaceholder.typicode.com").queryParam("postId", 1).when()
				.get("/comments");

		System.out.println(res.statusCode());

		if (res.statusCode() == 200) {
			System.out.println("API is working find");
		} else {
			System.out.println("API is working find");
		}

	}

	public class Query_Parameter2 {
		@Test
		public void query_parameter() {

			given()
				.baseUri("https://jsonplaceholder.typicode.com")
				.queryParam("postId", 1).
			when()
				.get("/comments").
			then()
				.assertThat().statusCode(200);

		}
	}
}