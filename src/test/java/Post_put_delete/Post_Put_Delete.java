package Post_put_delete;

import static io.restassured.RestAssured.given;
import java.io.File;

import org.json.JSONObject;
import org.testng.annotations.Test;
import io.restassured.http.ContentType;
import static org.hamcrest.Matchers.equalTo;

public class Post_Put_Delete {
	@Test
	public void post_request() {

		// IMP_NOTE : Whenever we doing a post request, we should be adding content
		// type.. What are we posting..So in this case we're posting JSON.

		File file = new File("Data/create_employee.json");
		int id = given()
			.baseUri("https://dummy.restapiexample.com/api/v1")
			.contentType(ContentType.JSON)
			.body(file).
		when()
			.post("/create").
		then()
			.statusCode(200)
			.body("data.name",equalTo("Israr"))
			.extract().path("data.id");
		
		System.out.println("ID details in response body  :"+id);
	}
	
	
	@Test
	public void post_using_json_object() {

		JSONObject jo = new JSONObject();
		jo.put("name", "Tim");
		jo.put("salary", "12345");
		jo.put("age", "34");
		
		int id = given()
			.baseUri("https://dummy.restapiexample.com/api/v1")
			.contentType(ContentType.JSON)
			.body(jo.toString()).
		when()
			.post("/create").
		then()
			.statusCode(200)
			.body("data.name",equalTo("Tim"))
			.extract().path("data.id");
		
		System.out.println("ID details in response body  :"+id);
	}
	
	@Test
	public void put_using_json_object() {

		JSONObject jo = new JSONObject();
		jo.put("name", "test");
		jo.put("salary", "12345");
		jo.put("age", "38");
		
		given()
			.baseUri("https://dummy.restapiexample.com/api/v1")
			.contentType(ContentType.JSON)
			.body(jo.toString()).
		when()
			.post("/update/24").
		then()
			.statusCode(200);
	}
	
	@Test
	public void delete_request() {
		
		String msg = given()
			.baseUri("https://dummy.restapiexample.com/api/v1")
			.contentType(ContentType.JSON).
		when()
			.delete("/delete/24").
		then()
			.statusCode(200)
			.extract().path("message");
		
		System.out.println(msg);
	}
}
