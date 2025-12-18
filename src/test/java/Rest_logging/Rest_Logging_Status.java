package Rest_logging;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

public class Rest_Logging_Status {
	@Test
	public void log_all_details() {
		
		// Logging Response Details
		String baseURI = "https://simple-tool-rental-api.glitch.me";
		String endPoint = "/tools";
		given()
			.baseUri(baseURI).
		when()
			.get(endPoint).
		then()
			.log().status();
	}
}
