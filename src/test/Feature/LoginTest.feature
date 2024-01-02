Feature: Login Feature

  Scenario: Verify the valid credentials
    Given I launch the browser and navigat to the URL
    When I pass username "admin" and password "manager"
    Then I verify the logged in application

  Scenario:Verify the invalid credentials
    Given I launch the browser and navigat to the URL
    When I pass userName "admin123" and password "manager123" and click on the login button
    Then I verify the not logged in application


