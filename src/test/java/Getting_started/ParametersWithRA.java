package getting_started;

import static io.restassured.RestAssured.given;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class ParametersWithRA {
	@Test
	public void f() {

		Response resp = given().param("category", "coffee").param("results", 10)
				.baseUri("https://simple-grocery-store-api.glitch.me").when().get("/status");

		
		Assert.assertEquals(resp.getStatusCode(), 200);

		if (resp.getStatusCode() == 200) {
			System.out.println("API is working Fine"+resp.getStatusCode());
		} else {
			System.out.println("API is not working Fine"+resp.getStatusCode());	
		}
	}
}
