@GUI
Feature: Flashposts functionality using GUI

  Scenario: Adding new flashpost by logged in user with proper data
    Given New user "Henry" is registered and logged in
    When User inputs the data into flashpost creation modal
    |It is never too late to start IT!|
    |#000000                          |
    |not public                       |
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

  Scenario: Adding new public flashpost and checking it by non logged in user
    Given New user "Arthur" is registered and logged in
    When User inputs the data into flashpost creation modal
      |public flashpost test            |
      |#000000                          |
      |public                           |
    Then A "Flashpost created successfully" simple alert text is displayed
    When User is logged out
    And User opens flashposts Page
    Then Flashpost author's name "Arthur" and flashpost text is displayed on top of flashposts

  Scenario: Adding new non-public flashpost and checking it by non logged in user
    Given New user "Carol" is registered and logged in
    When User inputs the data into flashpost creation modal
      |public flashpost test non logged in|
      |#000000                            |
      |non public                         |
    Then A "Flashpost created successfully" simple alert text is displayed
    When User is logged out
    And User opens flashposts Page
    Then Flashpost author's name "Carol" and flashpost text is not displayed on top of flashposts