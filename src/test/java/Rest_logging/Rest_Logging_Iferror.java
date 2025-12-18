package Rest_logging;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

public class Rest_Logging_Iferror {
	@Test
	public void log_iferror() {
		
		// Logging Response Details
		String baseURI = "https://simple-tool-rental-api.glitch.me";
		String endPoint = "/toeols1";
		
		String err = given()
			.baseUri(baseURI).
		when()
			.get(endPoint).
		then()
			.log().ifError()
			.log().ifStatusCodeIsEqualTo(404)
			.extract().path("error");
		
		System.out.println(err);
	}
}
