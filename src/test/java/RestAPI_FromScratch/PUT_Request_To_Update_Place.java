package RestAPI_FromScratch;

import static io.restassured.RestAssured.*;

import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.specification.RequestSpecification;

import static org.hamcrest.Matchers.*;


public class PUT_Request_To_Update_Place {

	@Test
	public void post_request() throws InterruptedException {
		
		// 1. Verify Status Code - 200
		// 2. Verify Body Contans "scope" as "APP" 
		// 3. Verify Response Received Is from Correct Server
		
		RestAssured.baseURI = "https://rahulshettyacademy.com";
		String response = given()
			.queryParam("key", "qaclick123")
			.header("Content-Type", "application/json")
			.body("{\r\n"
						+ "  \"location\": {\r\n"
						+ "    \"lat\": -38.383494,\r\n"
						+ "    \"lng\": 33.427362\r\n"
						+ "  },\r\n"
						+ "  \"accuracy\": 50,\r\n"
						+ "  \"name\": \"Frontline house\",\r\n"
						+ "  \"phone_number\": \"(+91) 983 893 3937\",\r\n"
						+ "  \"address\": \"29, side layout, cohen 09\",\r\n"
						+ "  \"types\": [\r\n"
						+ "    \"shoe park\",\r\n"
						+ "    \"shop\"\r\n"
						+ "  ],\r\n"
						+ "  \"website\": \"http://google.com\",\r\n"
						+ "  \"language\": \"French-IN\"\r\n"
						+ "}\r\n"
						+ "").	
		when()
			.post("maps/api/place/add/json").
		then()
			.assertThat().statusCode(200)
			.body("scope", equalTo("APP"))
			.header("server", "Apache/2.4.52 (Ubuntu)")
			.extract().response().asString();
		
		// Using JsonPath Class To Create Object
		JsonPath jpath = new JsonPath(response);
		String place_id = jpath.getString("place_id");
		
		System.out.println("place_id:"+place_id);
		
		// Update Address
		String newAddress = "70 Summer walk, USA";
		
		Thread.sleep(3000);
		
		given()
			.queryParam("key", "qaclick123")
			.header("Content-Type", "application/json")
			.body("{\r\n"
					+ "\"place_id\":\""+place_id+"\",\r\n"
					+ "\"address\":\""+newAddress+"\",\r\n"
					+ "\"key\":\"qaclick123\"\r\n"
					+ "}\r\n"
					+ "").
			when()
				.put("/maps/api/place/update/json").
			then()
				.statusCode(200)
				.body("msg",equalTo("Address successfully updated"));
		
		// Verify Address Is Updated Successfully	
		String addressResponse = given()
			.queryParam("key", "qaclick123")
			.queryParam("place_id", place_id).
		when()
			.get("/maps/api/place/get/json").
		then()
			.assertThat().statusCode(200).extract().response().asString();
		
		JsonPath js1 = new JsonPath(addressResponse);
		String actualAddress = js1.getString("address");
			
		System.out.println(actualAddress);
		
		Assert.assertEquals(newAddress, actualAddress);
				
		
	}

}