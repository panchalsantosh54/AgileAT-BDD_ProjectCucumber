Feature: AddNew Use

  Background: : Verify add new in in actitime application
    Given I launch the browser and navigat to the URL
    When I pass username "admin" and password "manager"
    And I click on the log in buttton

    Scenario: I navigate to the add data in user module
      Given I navigate to the user module
      When I click on new user firstname "cyber" lastname "success" emailid "cyber@123"
      And Click the save button

    Scenario: Verify the new user add successfuly
      Given I navigate to the user module
      When I click on the search drop down
      Then Veify add user successfuly