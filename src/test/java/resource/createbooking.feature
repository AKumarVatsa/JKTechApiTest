Feature: Create Booking

  Scenario: Successfully create a booking
    Given I have a booking payload
    When create booking request
    Then validation