package Rest_logging;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

public class Rest_Logging_Response_Headers {
	@Test
	public void log_response_headers() {
		
		// Logging Response Details
		String baseURI = "https://simple-tool-rental-api.glitch.me";
		String endPoint = "/tools";
		given()
			.baseUri(baseURI).
		when()
			.get(endPoint).
		then()
			.log().headers();
	}
}
