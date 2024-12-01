@API
Feature: Articles creation using API
  Checking articles functionality using not logged in user and API

  Scenario: User attempts to create a new article using valid data
    Given Request with valid generated article data is prepared
    When User creates new Article with prepared request
    Then API response should end with status code 401