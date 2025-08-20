package step;

import static io.restassured.RestAssured.given;
//import static org.junit.Assert.assertNotNull;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;
//import static org.junit.Assert.assertEquals;

import pojo.BookingDates;
import pojo.CreateBooking;
import io.cucumber.java.en.*;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class CreateBookingSteps {

    private CreateBooking bookingPayload;
    private BookingDates bookingDates;
    private Response response;

    @Given("I have a booking payload")
    public void i_have_a_booking_payload() {
        bookingPayload = new CreateBooking();
        bookingPayload.setFirstname("Adarsh");
        bookingPayload.setLastname("Kumar");
        bookingPayload.setTotalprice(500);
        bookingPayload.setDepositpaid(true);
        bookingDates = new BookingDates();
        bookingDates.setCheckin("2025-08-08");
        bookingDates.setCheckout("2025-08-09");
        bookingPayload.setBookingdates(bookingDates);
        bookingPayload.setAdditionalneeds("dinnar");
    }

    @When("create booking request")
    public void create_booking_request() {
        RestAssured.baseURI = "https://restful-booker.herokuapp.com";
        response = given().log().all()
                .header("Content-Type", "application/json")
                .body(bookingPayload)
                .when().post("/booking")
                .then().log().all().extract().response();
    }

    @Then("validation")
    public void validation() {
        assertEquals(200, response.getStatusCode());
        String bookingId = response.jsonPath().getString("bookingid");
        assertNotNull("Booking ID should not be null", bookingId);
        System.out.println("The booking id is: " + bookingId);
    }
}
