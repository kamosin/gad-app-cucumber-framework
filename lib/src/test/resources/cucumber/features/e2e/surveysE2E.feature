@GUI
Feature: Surveys functionality using GUI

  Scenario: Completing surveys and checking statistics
    Given New user "Christopher" is registered and logged in
    And User is on surveys page
    When User completes the REST API survey
    |true            |                    |
    |Swagger         | Postman            |
    |true            |                    |
    |true            |                    |
    |GithubActions   | Jenkins            |
    |Weekly          |                    |
    |E2eTests        | AccessibilityTests |
    |tekst rest api  |                    |
    And User completes the Automation Testing Survey
    |true            |                    |
    |four_five_years |one_two_Years       |
    |Playwright      |Selenium            |
    |JavaScript      |Java                |
    |FiftyToOneHundred|                   |
    |E2eTests        |AccessibilityTests  |
    |tekst automaty  |                    |
    Then Automation experience statistics in statistics page is increased
    And Rest API experience rectangle height is increased