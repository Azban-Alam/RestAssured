package Handling_Request_Parameters;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

public class From_Parameter {

	// For Form Parameters: https://postman-echo.com/post
	// multipart/form-data
	// application/x-www-form-urlencoded
	// application/json
	
	@Test
	public void from_parameter() {
		given()
		.baseUri("https://postman-echo.com")
		.contentType("application/x-www-form-urlencoded;charset=UTF-8")
		.formParam("First Name", "Shravya")
		.formParam("Last Name", "Deshmukh").
	when()
		.post("/post").
	then()
		.log().all()
		.statusCode(200);
	}
}
