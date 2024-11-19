Feature: User registration using GUI
  Checking if new User can be registered using GUI

#  @GUI
#  Scenario: User registers and logs in with valid data
#    Given User is on the landing page
#    When User clicks the Register button on navigation bar
#    Then The Registration page should be displayed
#    When User enters all required registration data
#    And Clicks the Register button
#    Then A "User created" popup should appear
#    And The user is redirected to the login page
#    When User enters email and password on the login page
#    And Clicks the Login button
#    Then User should be redirected to the account page

#  Scenario: New user tries to register with existing email adress
#    Given a new user is generated
#    When the user registers using API
#    Then API response should be successful with status code 201
#    When Another user is generated with the same email as the former user
#    And Another user tries to register
#    Then API response should not be successful with status code 409
#    And Error message should be "Email not unique"

  Scenario: User registration and login with valid data
    Given User is on the landing page
    When User registers with valid data on registration page
    Then A "User created" popup should appear
    And The user is redirected to the login page
    When Registered user logs in
    Then User is redirected to account page

  Scenario: User registration with existing user email
    Given User is on the landing page
    When User registers with valid data on registration page
    Then A "User created" popup should appear
    And The user is redirected to the login page
    When User registers using existing email
    Then "User not created! Email not unique" popup should be displayed