package getting_started;

import static io.restassured.RestAssured.given;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class ParametersWithRA2 {
	@Test
	public void f() {

		given()
		.param("category", "coffee")
		.param("results", 10)
		.baseUri("https://simple-grocery-store-api.glitch.me")
		.when().get("/status").then().assertThat().statusCode(200);		
	}
}
