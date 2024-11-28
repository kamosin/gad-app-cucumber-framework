@GUI @API
Feature: Articles functionality using GUI

  Scenario: Adding new article using proper data with polish and special characters
    Given New user "Henry" is registered and logged in
    When User inputs the data into new article form
      | Żółw wśród@ raf koralowych – #wyjątkowa podróż pełna emocji i % niespodzianek! |
      | Podróżując # wśród@ malowniczych! @ra$f ()&%koralowych, żółw majestatycznie unosi się w krystalicznie czystej wodzie. Odkryj piękno oceanu, którego tajemnice skrywają niezwykłe stworzenia. W tej podróży zobaczysz bogactwo barw, odcieni oraz różnorodność fauny, jakiej nie znajdziesz nigdzie indziej. Zbliż się do przyrody i zanurz w świat pełen emocji – od fascynacji po zachwyt. Niech ta przygoda pozostawi w Tobie niezapomniane wspomnienia.        |
    Then A "Article was created" popup is displayed
    And Number of created articles is increased by 1

  Scenario:  Adding new article with missing data
    Given New user "Andrew" is registered and logged in
    When User inputs only title into new article form
    Then A "Article was not created" popup is displayed
    And Number of created articles is increased by 0
    When User clears title field and inputs only body into new article form
    Then A "Article was not created" popup is displayed
    And Number of created articles is increased by 0

  Scenario: Adding new article by not logged in user
    Given User is on the landing page
    When User clicks start button
    Then Button to add new article is not visible