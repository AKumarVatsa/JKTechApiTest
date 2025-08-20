Feature: Create Booking with JSON file

  Scenario: Successfully create a booking using request body from JSON file
    Given I have a booking payload from "createbooking.json"
    When I send a POST request to "/booking"
    Then the response status code should be 200
    And I should see a booking id in the response
