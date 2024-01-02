Feature: Pass the value using scenario outline

  Scenario Outline: I pass the value using scenario out line
    Given I launch the browser and navigat to the URL
    When navigate to user module
    |first|<firstname> |
    | last| <lastname> |
    | email|  <email> |
    Examples:
    |firstname     |lastname      |email    |
    |   cyber      |  succes      | cs@123  |
    |   cyber      |              |  cs@123 |
    |              |  success     |  cs@123 |
    |   cyber      |              |         |

    Scenario: pass the value datatable
      Given I launch the browser and navigat to the URL
      When I pass the value in datatablt
      |firstname|lastname|email|
      |cyber    | success| cs@123 |
      |cyber    |        | cs@123  |
      |         | success |cs@123  |