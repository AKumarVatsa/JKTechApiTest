Feature: Sample API Test

  Scenario: Get user by ID
    Given I send a GET request to "/users/1"
    Then the response status code should be 200
    And the response should contain "Leanne Graham"