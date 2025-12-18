package framework_logic_design;

import static io.restassured.RestAssured.given;
import org.testng.annotations.Test;


public class PathParameterTest1 extends BaseTest {

    @Test
    public void getToolById() {
        given()
            .spec(requestSpec)
            .pathParam("toolId", 4643)
        .when()
            .get("/tools/{toolId}")
        .then()
            .spec(responseSpec)
            .log().all();
    }
}