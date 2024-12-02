@API @RequestManager @Articles
Feature: Articles creation using API
  Checking articles functionality using logged in user and API

  Background:
    Given A new user "Andy" is generated
    And the user "Andy" registers using API
    And the user "Andy" attempts to log in

  Scenario: User attempts to create a new article using valid data
    Given Request with valid generated article data is prepared
    When User creates new Article with prepared request
    Then API response should end with status code 201

  Scenario: User attempts to create a new article with missing body
    Given Request with missing body is prepared
    When User creates new Article with prepared request
    Then API response should end with status code 422
    And API response should contain 'One of mandatory field is missing' message

  Scenario: User attempts to create a new article with missing title
    Given Request with missing title is prepared
    When User creates new Article with prepared request
    Then API response should end with status code 422
    And API response should contain 'One of mandatory field is missing' message

  Scenario: User attempts to create a new article with Title longer than 128 characters
    Given Request with title longer than 128 characters is prepared
    When User creates new Article with prepared request
    Then API response should end with status code 422
    And API response should contain 'Field validation: \"title\" longer than \"128\"' message