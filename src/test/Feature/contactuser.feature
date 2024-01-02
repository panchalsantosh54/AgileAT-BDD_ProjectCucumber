Feature: Contact User

  Scenario: I navigate to the add contact in user module
    Given I navigate to the user module
    When I click on new user firstname "QA" lastname "Selenium" emailid "selenium@986"
    And Click the save button