package Framework_logic_design;

import static io.restassured.RestAssured.given;
import org.testng.annotations.Test;

public class PathParameterTest extends BaseTest {

    @Test
    public void getToolByDynamicId() {
        ApiUtils utils = new ApiUtils();
        int toolId = utils.getFirstToolId();  // dynamically fetched

        given()
            .spec(requestSpec)
            .pathParam("toolId", toolId)
        .when()
            .get("/tools/{toolId}")
        .then()
            .spec(responseSpec)
            .log().all();
    }  
}