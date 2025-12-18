package Framework_logic_design;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import io.restassured.config.RedirectConfig;
import io.restassured.config.RestAssuredConfig;
import org.testng.annotations.BeforeClass;

public class BaseTest {

    protected RequestSpecification requestSpec;
    protected ResponseSpecification responseSpec;

    @BeforeClass
    public void setup() {
        RestAssured.baseURI = "https://simple-tool-rental-api.glitch.me";

        requestSpec = new RequestSpecBuilder()
                .setBaseUri(RestAssured.baseURI)
                .addHeader("Accept", "application/json")
                .setRelaxedHTTPSValidation()
                .setConfig(RestAssuredConfig.config()
                        .redirect(RedirectConfig.redirectConfig().followRedirects(true)))
                .build();

        responseSpec = new ResponseSpecBuilder()
                .expectStatusCode(200)
                .build();
    }
}