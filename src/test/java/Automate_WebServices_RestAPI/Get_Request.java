package Automate_WebServices_RestAPI;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class Get_Request {
	
  // Simple Get Request : Verify 200 Status Code	
  @Test  
  public void get_request() {
	  
	  Response res = get("https://jsonplaceholder.typicode.com/todos/1");
	  System.out.println(res.statusCode());
	  
	  // Verify 200 Status Code 
	  Assert.assertEquals(res.statusCode(), 200);
  }
  
//Simple Get Request : Verify 401 Status Code	
 @Test  
 public void get_request_invalid_status_code() {
	  
	  Response res = get("https://jsonplaceholder.typicode.com/todos/1234");
	  System.out.println(res.statusCode());
	  
	  // Verify 200 Status Code 
	  Assert.assertEquals(res.statusCode(), 404);
 }
}
