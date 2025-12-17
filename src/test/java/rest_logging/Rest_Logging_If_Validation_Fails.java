package rest_logging;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

public class Rest_Logging_If_Validation_Fails {
	@Test
	public void log_if_validation_fails() {
		
		// Logging If Validation Fails
		String baseURI = "https://simple-tool-rental-api.glitch.me";
		String endPoint = "/toeols1";
		
		String err = given()
			.baseUri(baseURI).
		when()
			.get(endPoint).
		then()
		.log().ifValidationFails()
		.statusCode(200)
		.extract().path("error");
		
		System.out.println(err);
	}
}
