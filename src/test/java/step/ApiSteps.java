package step;

import io.cucumber.java.en.*;
import io.restassured.response.Response;

import config.ConfigManager;
import constants.EndPoints;

import static io.restassured.RestAssured.*;
import static org.testng.Assert.assertEquals;

public class ApiSteps {
    private Response response;

    @Given("I send a GET request")
    public void iSendAGetRequestTo() {
        response = given()
        		.baseUri(ConfigManager.get("base.url").concat(EndPoints.GET_USER))
                .when()
                .get();
    }

    @Then("response validation")
    public void theResponseShouldContain() {
        assertEquals(200, response.getStatusCode());
    }
}
