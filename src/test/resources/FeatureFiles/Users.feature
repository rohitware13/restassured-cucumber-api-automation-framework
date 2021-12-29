Feature: As a user
  I want to perform different API calls to validate user features

  @get @smoke
  Scenario: User retrieves user list
    Given the user wants to make "get" api call
    When the user sends the request with valid parameter
    Then the response code is success 200

  @post @smoke
  Scenario: User can add new user
    Given the user wants to make "post" api call
    When the user sends the request with payload
    Then the response code is created 201
    And the user id should be return as response

  @put @smoke
  Scenario: User can update existing user
    Given the user wants to make "put" api call
    When the user sends the request with payload to update
    Then the response code is success 200
    And the user data is updates successfully