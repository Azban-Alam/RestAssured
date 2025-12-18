package Getting_started;

import static io.restassured.RestAssured.given;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class NewTest {
	@Test
	public void f() {

		Response resp= given().baseUri("https://simple-grocery-store-api.glitch.me").when().get("/status");
		System.out.println(resp.getStatusCode());
		Assert.assertEquals(resp.getStatusCode(), 200);

	}
}
