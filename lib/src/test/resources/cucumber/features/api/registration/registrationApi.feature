@API @RequestManager @Registration
Feature: User registration using API
  Checking if new User can be registered using API call

  @Smoke
  Scenario: User registers and logs in with proper data
    Given A new user "Andy" is generated
    When the user "Andy" registers using API
    Then API response should end with status code 201
    When the user "Andy" attempts to log in
    Then the login should be successful with status code 200

  Scenario: User registers with existing email
    Given A new user "Gary" is generated
    When the user "Gary" registers using API
    Then API response should end with status code 201
    When A new user "Henry" is generated with existing email
    And the user "Henry" registers using API
    Then API response should end with status code 409
    And API response should contain "Email not unique" message

  Scenario: Users registers only with email
    Given A new user "Jack" only with email is generated
    When the user "Jack" registers using API
    Then API response should end with status code 422
    And API response should contain "One of mandatory field is missing" message

  Scenario:  Users registers with wrong date format
    Given A new user "Tommy" with wrong birth date format is generated
    When the user "Tommy" registers using API
    Then API response should end with status code 422
    And API response should contain "Invalid email" message