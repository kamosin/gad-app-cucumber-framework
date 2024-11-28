@GUI
Feature: Flashposts functionality using GUI

  Scenario: Adding new flashpost by logged in user with proper data
    Given New user "Henry" is registered and logged in
    When User inputs the data into flashpost creation modal
    |It is never too late to start IT!|
    |#000000                          |
    Then A "Flashpost created successfully" simple alert text is displayed
    And Flashpost author's name "Henry" and surname is displayed on top of flashposts

#  Scenario: Adding new flashpost with too long message
#    Given New user "Elon" is registered and logged in
#    When User inputs the data into flashpost creation modal
#    |To jest tekst na 129 znaków To jest tekst na 129 znaków To jest tekst na 129 znaków To jest tekst na 129 znaków To jest tekst na.|
#    |#000000                                                                                                                          |
#    Then After reaching 128 characters no more text will be added

  Scenario: Adding new empty flashpost by not logged in user
    Given User is on the landing page
    When User clicks start button
    And User creates new flaspost with empty message
    Then A "Flashpost can't be empty" simple alert text is displayed

  Scenario: Adding new flashpost by not logged in user with proper data
    Given User is on the landing page
    When User clicks start button
    And User inputs the data into flashpost creation modal
    |It is a trap!                    |
    |#dddddd                          |
    Then A "You can't create this flashpost." simple alert text is displayed