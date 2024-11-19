Feature: User registration using API
  Checking if new User can be registered using API call

  Scenario: User registers and logs in with proper data
    Given a new user is generated
    When the user registers using API
    Then API response should be successful with status code 201
    When the user attempts to log in
    Then the login should be successful with status code 200

#    @API
#  Scenario: New user tries to register with existing email adress
#    Given a new user is generated
#    When the user registers using API
#    Then API response should be successful with status code 201
#    When Another user is generated with the same email as the former user
#    And Another user tries to register
#    Then API response should not be successful with status code 409
#    And Error message should be "Email not unique"