@API @RequestManager @Flashposts
Feature: Flasposts creation using API
  Checking flashposts functionality using logged in user and API

  Background:
    Given A new user "Andy" is generated
    And the user "Andy" registers using API
    And the user "Andy" attempts to log in

  Scenario: User attempts to read all flashposts
    When User reads all flashposts using API
    Then API response should end with status code 200

  Scenario: User attempts to create a new flashpost using valid data
    Given Request with valid generated flashpost data is prepared
    When User creates new flashpost with prepared request
    Then API response should end with status code 201
    And Number of created flashposts is increased by 1

  Scenario:  User attempts to create a new flashpost using too long message
    Given Request with too long flashpost data is prepared
    When User creates new flashpost with prepared request
    Then API response should end with status code 422
    And API response should contain 'Field validation: \"body\" longer than "128"' message

  Scenario: User attempts to create a new public flashpost, logs out and checks if flashpost is saved
    Given Request with valid flashpost data is prepared
      |It is never too late to start IT!|
      |#000000                          |
      |public                           |
    When User creates new flashpost with prepared request
    Then API response should end with status code 201
    When User logs out using API
    And User tries to get created flashpost
    Then Response body contains flashpost text

  Scenario: User attempts to create a new non-public flashpost, logs out and checks if flashpost is saved and accessible using API
    Given Request with valid flashpost data is prepared
      |non public test flashposts       |
      |#000000                          |
      |non-public                       |
    When User creates new flashpost with prepared request
    Then API response should end with status code 201
    When User logs out using API
    And User tries to get created flashpost
    Then API response should end with status code 401
