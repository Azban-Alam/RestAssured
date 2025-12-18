package getting_started;

import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class Getting_Started {
	@Test
	public void simple_get_request() {
		// Scenario : Verify The Status Code Of Response Is 200
		String baseURI = "https://simple-tool-rental-api.glitch.me";
		String endPoint = "/tools";
		given().baseUri(baseURI).when().get(endPoint).then().statusCode(200);
	}

	@Test
	public void verify_reponse_body() {
		// Scenario : Extract Response From Json
		String baseURI = "https://simple-tool-rental-api.glitch.me";
		String endPoint = "/tools";
		Response response = given().baseUri(baseURI).when().get(endPoint).then().extract().response();
		System.out.println(response.asString());
	}

	@Test
	public void verify_statusline() {
		// Scenario : Verify The Status Line
		String baseURI = "https://simple-tool-rental-api.glitch.me";
		String endPoint = "/tools";
		given().baseUri(baseURI).when().get(endPoint).then().statusCode(200).statusLine("HTTP/1.1 200 OK");
	}
	
}
