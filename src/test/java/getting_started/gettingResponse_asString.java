package getting_started;

import static io.restassured.RestAssured.given;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class gettingResponse_asString {
	@Test
	public void f() {

		Response resp = given()
		.param("category", "coffee")
		.param("results", 10)
		.baseUri("https://simple-grocery-store-api.glitch.me")
		.when().get("/status");		
		
		System.out.println(resp.asString());
	}
}
