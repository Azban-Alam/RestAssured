package Handling_Request_Parameters;

import static io.restassured.RestAssured.given;
import io.restassured.config.RedirectConfig;
import io.restassured.config.RestAssuredConfig;
import org.testng.annotations.Test;

public class Path_Parameter {
    @Test
    public void path_parameter() {
        given()
            .baseUri("https://simple-tool-rental-api.glitch.me")   // initial endpoint
            .pathParam("toolId", 4643)
            .config(RestAssuredConfig.config()
                .redirect(RedirectConfig.redirectConfig().followRedirects(true))) // 👈 enable redirects
            .relaxedHTTPSValidation()
            .log().uri()
        .when()
            .get("/tools/{toolId}")   // RestAssured will follow to .click domain
        .then()
            .log().all()
            .statusCode(200);         // assert success
    }
    
    // Multiple Path Parameter - Imaginary Scenario
    
    @Test
    public void multiple_path_parameter() {
        given()
            .baseUri("https://simple-tool-rental-api.glitch.me")   // initial endpoint
            .pathParam("toolId", 4643)
            .pathParam("name", "Israr")
            .config(RestAssuredConfig.config()
                .redirect(RedirectConfig.redirectConfig().followRedirects(true))) // 👈 enable redirects
            .relaxedHTTPSValidation()
            .log().uri()
        .when()
            .get("/tools/{toolId}/name/{name}")   // RestAssured will follow to .click domain
        .then()
            .log().all()
            .statusCode(200);         // assert success
    }
}