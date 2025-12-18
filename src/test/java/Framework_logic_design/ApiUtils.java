package framework_logic_design;

import static io.restassured.RestAssured.given;
import io.restassured.path.json.JsonPath;

public class ApiUtils extends BaseTest {

    public int getFirstToolId() {
        String response = 
            given()
                .spec(requestSpec)
            .when()
                .get("/tools")
            .then()
                .statusCode(200)
                .extract()
                .asString();

        JsonPath jsonPath = new JsonPath(response);
        return jsonPath.getInt("[0].id"); // get the first tool’s ID
    }
}