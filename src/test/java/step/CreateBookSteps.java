package step;

import static io.restassured.RestAssured.given;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.testng.Assert;

import io.cucumber.java.en.*;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.path.json.JsonPath;
import static org.testng.Assert.*;

public class CreateBookSteps {

    private String requestBody;
    private Response response;

    @Given("I have a booking payload from {string}")
    public void i_have_a_booking_payload_from(String fileName) throws IOException {
        byte[] bytefromJson = Files.readAllBytes(Paths.get("createbooking.json"));
        requestBody = new String(bytefromJson);
    }

    @When("I send a POST request to {string}")
    public void i_send_a_post_request_to(String endpoint) {
        RestAssured.baseURI = "https://restful-booker.herokuapp.com";
        response = given().log().all()
                .header("Content-Type", "application/json")
                .body(requestBody)
                .when()
                .post(endpoint)
                .then()
                .log().all()
                .extract().response();
    }

    @Then("the response status code should be {int}")
    public void the_response_status_code_should_be(Integer statusCode) {
        Assert.assertEquals(statusCode.intValue(), response.getStatusCode());
    }

    @Then("I should see a booking id in the response")
    public void i_should_see_a_booking_id_in_the_response() {
        JsonPath js = new JsonPath(response.asString());
        String bookingID = js.getString("bookingid");
        Assert.assertNotNull("Booking ID is null!", bookingID);
        System.out.println("The booking id is: " + bookingID);
    }
}
