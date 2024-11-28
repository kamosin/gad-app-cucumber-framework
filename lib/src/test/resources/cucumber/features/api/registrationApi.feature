@API
Feature: User registration using API
  Checking if new User can be registered using API call

  Scenario: User registers and logs in with proper data
    Given a new user "Andy" is generated
    When the user "Andy" registers using API
    Then API response should be successful with status code 201
    When the user "Andy" attempts to log in
    Then the login should be successful with status code 200
