package step;

import io.cucumber.java.en.*;
import io.restassured.response.Response;

import config.ConfigManager;
import constants.EndPoints;

import static io.restassured.RestAssured.*;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class ApiSteps {
    private Response response;

    @Given("I send a GET request")
    public void iSendAGetRequestTo() {
        response = given()
        		.baseUri(ConfigManager.get("base.url").concat(EndPoints.GET_USER))
                .when()
                .get();
    }

    @Then("the response status code should be {int}")
    public void theResponseStatusCodeShouldBe(int statusCode) {
        assertEquals(statusCode, response.getStatusCode());
    }

    @Then("the response should contain {string}")
    public void theResponseShouldContain(String expectedValue) {
        assertTrue(response.getBody().asString().contains(expectedValue));
    }
}
