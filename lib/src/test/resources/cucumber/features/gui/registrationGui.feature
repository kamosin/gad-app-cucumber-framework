@GUI
Feature: User registration using GUI
  Checking if new User can be registered using GUI

  Scenario: User registration and login with valid data
    Given User is on the landing page
    When User "John" is registered with valid data on registration page
    Then A "User created" popup should appear
    And The user is redirected to the login page
    When Registered user "John" logs in
    Then User "John" is redirected to account page

  Scenario: User registration with existing user email
    Given User is on the landing page
    When User "John" is registered with valid data on registration page
    Then A "User created" popup should appear
    And The user is redirected to the login page
    When User "Mark" is registered using existing email
    Then A "User not created! Email not unique" popup should appear

  Scenario: User registration with only email address
    Given User is on the landing page
    When User tries to register only with email address
    Then "This field is required" information is displayed below first name, last name, and password fields