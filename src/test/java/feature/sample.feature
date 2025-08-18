Feature: Book management
Scenario: Create a book in user collection
Given the user is authenticated
When the user adds a book to the collection
Then the book should be added successfully