@API
Feature: Flasposts creation using API
  Checking flashposts functionality using not logged in user and API

  Scenario:  User attempts to create a new flashpost using valid data as non-logged in user
    Given Request with valid generated flashpost data is prepared
    When User creates new flashpost with prepared request
    Then API response should end with status code 401